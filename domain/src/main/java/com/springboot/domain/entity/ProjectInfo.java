package com.springboot.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author wuhui
 * @Date 2018/11/21
 * @Description
 */
@Data
public class ProjectInfo {
    // id
    private Integer id;
    //项目编号
    private String projectCode;
    // 项目名
    private String projectName;
    // 商务负责人
    private String businessDirector;
    // 产品负责人
    private String productManager;
    // 测试负责人
    private String testSupervisor;
    // 基电参与人员
    private String basicPowerParticipants;
    // 项目发起时间
    private Date projectStartTime;
    // 项目截止时间
    private Date projectEndTime;
    // 需求方
    private String demandSide;
    // 业务条件
    private String businessConditions;
    // 目前开发阶段
    private String currentStage;
    // 项目验收时间
    private Date acceptanceTime;
    // 项目预算
    private Long projectBudget;
    // 预算来源
    private Double budgetSource;
    // 项目简介
    private String projectIntroduction;
    // 终端
    private String terminal;
    // 工程项目名
    //private String projectName;
    // 访问地址
    private String accessAddress;
    // 主要界面
    private String mainPage;
    // 测试账号
    private String testAccount;
    // 测试密码
    private String testPassword;
    // 部署服务器
    private String serverInfo;
    // 部署路径
    private String addressInfo;
    // 代码svn地址
    private String svnPathInfo;
    // 使用的第三方服务
    private String thirdPartyServices;
    // 子项目
    private String subprojects;
    // 添加时间
    private Date projectAddTime;
    // 最新修改时间
    private Date updateTime;
    // 技术文档
    private String technicalDocuments;
    // 接口文档
    private String interfaceDocuments;
    // 白皮书
    private String whitePaper;
    // 需求文档
    private String requestDocuments;
    // 数据库信息
    private String dataSourceInfo;
    // 备注
    private String remarks;
    // 创建时间
    private Date gmtCreate;
    // 修改时间
    private Date gmtModified;
    // 是否删除默认0，1表示软删除
    private Integer isDel;
}
