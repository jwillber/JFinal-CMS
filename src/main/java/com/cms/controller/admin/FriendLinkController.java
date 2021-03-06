/*
 * 
 * 
 * 
 */
package com.cms.controller.admin;

import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.ArrayUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cms.Feedback;
import com.cms.entity.FriendLink;
import com.cms.routes.RouteMapping;


/**
 * Controller - 友情链接
 * 
 * 
 * 
 */
@RouteMapping(url = "/admin/friend_link")

public class FriendLinkController extends BaseController {


	/**
	 * 添加
	 */
	public void add() {
		render(getView("friend_link/add"));
	}

	/**
	 * 保存
	 */
	public void save() {
		FriendLink friendLink = getModel(FriendLink.class,"",true);   
		friendLink.setCreateDate(new Date());
		friendLink.setModifyDate(new Date());
		friendLink.save();
		redirect(getListQuery("/admin/friend_link/list"));
	}

	/**
	 * 编辑
	 */
	public void edit() {
		Long id = getParaToLong("id");
		setAttr("friendLink", new FriendLink().dao().findById(id));
		render(getView("friend_link/edit"));
	}

	/**
	 * 更新
	 */
	public void update() {
		FriendLink friendLink = getModel(FriendLink.class,"",true);   
		friendLink.setModifyDate(new Date());
		friendLink.update();
		redirect(getListQuery("/admin/friend_link/list"));
	}
	
	   /**
     * 修改排序
     */
    public void updateSort(){
        String sortArray = getPara("sortArray");
        JSONArray jsonArray = JSONArray.parseArray(sortArray);
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Long id = jsonObject.getLong("id");
            Integer sort = jsonObject.getInteger("sort");
            FriendLink friendLink = new FriendLink().dao().findById(id);
            friendLink.setSort(sort);
            friendLink.update();
        }
        renderJson(Feedback.success(new HashMap<>()));
    }

	/**
	 * 列表
	 */
	public void list() {
	    String name = getPara("name");
		Integer pageNumber = getParaToInt("pageNumber");
		if(pageNumber==null){
			pageNumber = 1;
		}
		setAttr("page", new FriendLink().dao().findPage(name,pageNumber,PAGE_SIZE));
		setAttr("name", name);
		render(getView("friend_link/list"));
	}

	/**
	 * 删除
	 */
	public void delete() {
		Long ids[] = getParaValuesToLong("ids");
		if(ArrayUtils.isNotEmpty(ids)){
			for(Long id:ids){
				new FriendLink().dao().deleteById(id);
			}
		}
		renderJson(Feedback.success(new HashMap<>()));
	}

}