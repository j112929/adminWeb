package com.jzl.controller.user;
import java.util.HashMap;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.appcore.page.Page;
import com.jzl.controller.AbstractBackController;
import com.jzl.po.user.User;
import com.jzl.service.user.UserService;
import com.jzl.to.ResultTO;



/**
 * 【】控制器
 * 
 * @author AutoCode 309444359@qq.com
 * @date 2016-12
 * 
 */
@Controller
@RequestMapping("user")
public class UserController extends AbstractBackController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserService userService;
    

    
    /**
     * 进入【】主页
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-12
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        // 加载公共数据
        initIndex(model);
        return "back/user/user.index";
    }
    
    /**
     * 分页查询【】
     * @param key
     * @param pageSize
     * @param pageIndex
     * @return
     * @return Page<Map<String,Object>>
     * @author AutoCode
     * @date 2016-12
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @ResponseBody
    public Page<Map<String, Object>> page(String key, int pageSize, int pageIndex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key", key);
        Page<Map<String, Object>> page = userService.page(map,pageIndex, pageSize);
        return page;
    }
    
    /**
     * 查询【】详情
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-12
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(Model model, Integer id) {
        // 加载公共数据
        initIndex(model);
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("id", id); 
        model.addAttribute("user", userService.selectObject(map));
        return "back/user/user.detail";
    }
    
    /**
     * 进入新增【】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-12
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        // 加载公共数据
        initIndex(model);
        return "back/user/user.edit";
    }
    
    /**
     * 新增【】数据
     * @param user
     * @return ResultTO
     * @author AutoCode
     * @date 2016-12
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO addUser(@ModelAttribute User user, BindingResult result) {
        try {
            userService.insert(user);
            LOGGER.info("用户【{}】添加数据【{}】成功", new Object[] { this.getUserId(), user } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】添加数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), user, e });
            return ResultTO.newFailResultTO("添加失败", null);
        }
        return ResultTO.newSuccessResultTO("添加成功", null);
    }
    
    /**
     * 进入修改【】页面
     * @param model
     * @return string
     * @author AutoCode
     * @date 2016-12
     */
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(Model model, Integer id) {
        // 加载公共数据
        initIndex(model);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id); 
        model.addAttribute("user", userService.selectObject(map));
        return "back/user/user.edit";
    }
    
    /**
     * 修改【】数据
     * @param user
     * @return ResultTO
     * @author AutoCode
     * @date 2016-12
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO editUser(@ModelAttribute User user, BindingResult result) {
        try {
            userService.update(user);
            LOGGER.info("用户【{}】修改数据【{}】成功", new Object[] { this.getUserId(), user } );
        } catch (Exception e) {
            LOGGER.error("用户【{}】修改数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), user, e });
            return ResultTO.newFailResultTO("更新失败", null);
        }
        return ResultTO.newSuccessResultTO("更新成功", null);
    }
    
    /**
     * 删除【】数据
     * @param id
     * @return ResultTO
     * @author AutoCode
     * @date 2016-12
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResultTO deleteUser(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("id", id); 
            userService.delete(map);
            LOGGER.info("用户【{}】删除数据【{}】成功", new Object[] { this.getUserId(), id });
        } catch (Exception e) {
            LOGGER.error("用户【{}】删除数据【{}】失败 Exception:【{}】", new Object[] { this.getUserId(), id, e });
            return ResultTO.newFailResultTO("删除失败", null);
        }
        return ResultTO.newSuccessResultTO("删除成功", null);
    }
    
}
