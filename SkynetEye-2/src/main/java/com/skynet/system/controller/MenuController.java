/** 
 * Project Name:SkynetEye
 * File Name:MenuController.java 
 * Package Name:com.skynet.system.controller 
 * History
 * Seq   Date        Developer     email                   
 *  ---------------------------------------------------------------------------
 *  1    2018年8月26日    zeroLi       343077359@qq.com
 *
 *
 * Fcuntion Description :
 *
 *  ---------------------------------------------------------------------------
 * Copyright (c) 2018, SkynetEye All Rights Reserved. 
 * 
 */
package com.skynet.system.controller;

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
import com.skynet.common.controller.AbstractBaseController;
import com.skynet.common.utils.Result;
import com.skynet.system.bean.Esysmeudef;
import com.skynet.system.service.MenuService;

@RequestMapping("/sys/menu")
@Controller
public class MenuController extends AbstractBaseController {
	String prefix = "system/menu";
	@Autowired
	MenuService menuService;

	@RequiresPermissions("sys:menu:menu")
	@RequestMapping()
	String menu(Model model) {
		return prefix + "/menu";
	}

	@RequiresPermissions("sys:menu:menu")
	@RequestMapping("/list")
	@ResponseBody
	List<Esysmeudef> list(@RequestParam Map<String, Object> params) {
		List<Esysmeudef> menuList = menuService.list(params);
		return menuList;
	}

//	@Log("添加菜单")
	@RequiresPermissions("sys:menu:add")
	@RequestMapping("/add/{pId}")
	String add(Model model, @PathVariable("pId") Long pId) {
		model.addAttribute("pId", pId);
		if (pId == 0) {
			model.addAttribute("pName", "根目录");
		} else {
			model.addAttribute("pName", menuService.get(pId).getName());
		}
		return prefix + "/add";
	}

//	@Log("编辑菜单")
	@RequiresPermissions("sys:menu:edit")
	@RequestMapping("/edit/{id}")
	String edit(Model model, @PathVariable("id") Long id) {
		Esysmeudef esysmeudef = menuService.get(id);
		Long pId = esysmeudef.getParentId();
		model.addAttribute("pId", pId);
		if (pId == 0) {
			model.addAttribute("pName", "根目录");
		} else {
			model.addAttribute("pName", menuService.get(pId).getName());
		}
		model.addAttribute("menu", esysmeudef);
		return prefix + "/edit";
	}

//	@Log("保存菜单")
	@RequiresPermissions("sys:menu:add")
	@PostMapping("/save")
	@ResponseBody
	Result save(Esysmeudef esysmeudef) {
//		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
//			return Result.error(1, "演示系统不允许修改,完整体验请部署程序");
//		}
		if (menuService.create(esysmeudef) > 0) {
			return Result.success();
		} else {
			return Result.error(1, "保存失败");
		}
	}

//	@Log("更新菜单")
	@RequiresPermissions("sys:menu:edit")
	@PostMapping("/update")
	@ResponseBody
	Result update(Esysmeudef esysmeudef) {
//		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
//			return Result.error(1, "演示系统不允许修改,完整体验请部署程序");
//		}
		if (menuService.update(esysmeudef) > 0) {
			return Result.success();
		} else {
			return Result.error(1, "更新失败");
		}
	}

//	@Log("删除菜单")
	@RequiresPermissions("sys:menu:remove")
	@PostMapping("/remove")
	@ResponseBody
	Result remove(Long id) {
//		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
//			return Result.error(1, "演示系统不允许修改,完整体验请部署程序");
//		}
		if (menuService.delete(id) > 0) {
			return Result.success();
		} else {
			return Result.error(1, "删除失败");
		}
	}

	@RequestMapping("/tree")
	@ResponseBody
	Tree<Esysmeudef> tree() {
		Tree<Esysmeudef> tree = menuService.getTree();
		return tree;
	}

	@RequestMapping("/tree/{roleId}")
	@ResponseBody
	Tree<Esysmeudef> tree(@PathVariable("roleId") Long roleId) {
		Tree<Esysmeudef> tree = menuService.getTree(roleId);
		return tree;
	}
}
