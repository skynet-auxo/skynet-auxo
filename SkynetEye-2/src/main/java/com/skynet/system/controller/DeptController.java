/** 
 * Project Name:SkynetEye
 * File Name:DeptController.java 
 * Package Name:com.skynet.system.controller 
 * History
 * Seq   Date        Developer     email                   
 *  ---------------------------------------------------------------------------
 *  1    2018年8月24日    zeroLi       343077359@qq.com
 *
 *
 * Fcuntion Description : 部门管理
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, SkynetEye All Rights Reserved. 
 * 
 */
package com.skynet.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skynet.common.bean.Tree;
import com.skynet.common.constant.SkynetConstant;
import com.skynet.common.controller.AbstractBaseController;
import com.skynet.common.utils.Result;
import com.skynet.system.bean.Esecdptdef;
import com.skynet.system.service.DeptService;

@Controller
@RequestMapping("/system/sysDept")
public class DeptController extends AbstractBaseController {
	
	private String prefix = "system/dept";
	@Autowired
	private DeptService deptService;

	@RequestMapping()
	@RequiresPermissions("system:sysDept:sysDept")
	String dept() {
		return prefix + "/dept";
	}

//	@ApiOperation(value = "获取部门列表", notes = "")
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("system:sysDept:sysDept")
	public List<Esecdptdef> list() {
		Map<String, Object> query = new HashMap<>(16);
		List<Esecdptdef> sysDeptList = deptService.list(query);
		return sysDeptList;
	}

	@RequestMapping("/add/{pId}")
	@RequiresPermissions("system:sysDept:add")
	String add(@PathVariable("pId") Long pId, Model model) {
		model.addAttribute("pId", pId);
		if (pId == 0) {
			model.addAttribute("pName", "总部门");
		} else {
			model.addAttribute("pName", deptService.get(pId).getName());
		}
		return prefix + "/add";
	}

	@RequestMapping("/edit/{deptId}")
	@RequiresPermissions("system:sysDept:edit")
	String edit(@PathVariable("deptId") Long deptId, Model model) {
		Esecdptdef sysDept = deptService.get(deptId);
		model.addAttribute("sysDept", sysDept);
		
		if (SkynetConstant.DEPT_ROOT_ID.equals(sysDept.getParentId())) {
			model.addAttribute("parentDeptName", "无");
		} else {
			Esecdptdef parDept = deptService.get(sysDept.getParentId());
			model.addAttribute("parentDeptName", parDept.getName());
		}
		return prefix + "/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:sysDept:add")
	public Result create(Esecdptdef sysDept) {
//		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
//			return Result.error(1, "演示系统不允许修改,完整体验请部署程序");
//		}
		if (deptService.create(sysDept) > 0) {
			return Result.success();
		}
		return Result.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:sysDept:edit")
	public Result update(Esecdptdef sysDept) {
//		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
//			return Result.error(1, "演示系统不允许修改,完整体验请部署程序");
//		}
		if (deptService.update(sysDept) > 0) {
			return Result.success();
		}
		return Result.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("system:sysDept:remove")
	public Result delete(Long deptId) {
//		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
//			return Result.error(1, "演示系统不允许修改,完整体验请部署程序");
//		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentId", deptId);
		if (deptService.count(map) > 0) {
			return Result.error(1, "包含下级部门,不允许修改");
		}
		if (deptService.checkDeptHasUser(deptId)) {
			if (deptService.delete(deptId) > 0) {
				return Result.success();
			}
		} else {
			return Result.error(1, "部门包含用户,不允许修改");
		}
		return Result.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:sysDept:batchRemove")
	public Result remove(@RequestParam("ids[]") Long[] deptIds) {
//		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
//			return Result.error(1, "演示系统不允许修改,完整体验请部署程序");
//		}
		deptService.batchDelete(deptIds);
		return Result.success();
	}

	@RequestMapping("/tree")
	@ResponseBody
	public Tree<Esecdptdef> tree() {
		Tree<Esecdptdef> tree = new Tree<Esecdptdef>();
		tree = deptService.getTree();
		return tree;
	}

	@RequestMapping("/treeView")
	String treeView() {
		return prefix + "/deptTree";
	}
}
