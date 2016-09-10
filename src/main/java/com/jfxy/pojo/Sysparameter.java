package com.jfxy.pojo;

import java.math.BigDecimal;

/**
 * 系统参数表 <br />
 * sysparameter<br />
 * @author hejiajie
 * @date 2016-01-11 13:48:04
 */
public class Sysparameter   {
   /**
    * 主键   <br />
    * 允许为空  NO <br />
    * 数据长度 0<br />
    */
   private Integer parameterid;
   /**
    * 启用密码验证（1启用，0禁用）   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer pwd;
   /**
    * 启用会员登记赠送余额及积分（1启用，0禁用）   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer moneyandpoint;
   /**
    * 启用积分转换等级 （1启用，0禁用）   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer autolevel;
   /**
    * 会员等级允许降级 （1启用，0禁用）   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer degradelevel;
   /**
    * 设置会员过期时间（1启用，0禁用）   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer pasttime;
   /**
    * 推荐会员获得积分（1启用，0禁用）   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer recommendpoint;
   /**
    * 积分清零提醒周期 （天数）   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer pointperiod;
   /**
    * 前速前缀（默认为ks）   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String expenseprefix;
   /**
    * 商品前缀（默认为gd）   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String goodsexpenseprefix;
   /**
    * 时间前缀（默认为gr）   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String timeexpenseprefix;
   /**
    * 会员充次前缀（默认为sd）   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String memcountprefix;
   /**
    * 会员消费次数（默认为fd）   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String memrechargeprefix;
   /**
    * 商品前缀（默认为tt）   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String goodsinprefix;
   /**
    * 商品消费前缀（默认为gd）   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String goodsallotprefix;
   /**
    * 会员提现前缀（默认为gd）   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String memdrawmoneyprefix;
   /**
    * 会员积分消费前缀（默认为gd）   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String mempointchangeprefix;
   /**
    * 礼品兑换前缀（默认为gd）   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String giftexchangeprefix;
   /**
    * 启用打印功能 （1启用，0禁用）   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer autoprint;
   /**
    * 是否启用打印预览（1启用，0禁用）   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer accordprint;
   /**
    * 打印小票标题   <br />
    * 允许为空  YES <br />
    * 数据长度 100<br />
    */
   private String printtitle;
   /**
    * 打印小票脚注   <br />
    * 允许为空  YES <br />
    * 数据长度 100<br />
    */
   private String printfootnote;
   /**
    * 启用系统通知短信功能   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer sms;
   /**
    *  启用系统通知短信自动发送功能   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer moneysms;
   /**
    * 启用统一所有店铺短信后缀名   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer issmsshopname;
   /**
    * 统一店铺短信后缀名   <br />
    * 允许为空  YES <br />
    * 数据长度 100<br />
    */
   private String smsshopname;
   /**
    * 通知短信序列号   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String smsseries;
   /**
    * 通知序列号密码   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String smsserialpwd;
   /**
    * 账户提现折损比率   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Double drawmoneypercent;
   /**
    * 启用来电提醒功能   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer tel;
   /**
    * 启用非会员来电提醒功能   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer telnomember;
   /**
    * 启用会员消费员工提成功能    <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer isstaff;
   /**
    * 1按员工提成比例提成\0按商品提成类型提成   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer stafftype;
   /**
    * 启用会员多级积分提成   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer pointlevel;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer mms;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String mmsseries;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String mmsserialpwd;
   /**
    * 启用余额支付   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer ispaycard;
   /**
    * 启用现金支付   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer ispaycash;
   /**
    * 启用银联支付   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer ispaybink;
   /**
    * 启用优惠券   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer ispaycoupon;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer regnullpwd;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 100<br />
    */
   private String emailadress;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 100<br />
    */
   private String emailpwd;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 100<br />
    */
   private String emailsmtp;
   /**
    * 商品库存报警数量   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer stockcount;
   /**
    * 商品单位（个）   <br />
    * 允许为空  YES <br />
    * 数据长度 200<br />
    */
   private String unitlist;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer weixinsmsvcode;
   /**
    * 启用会员登记发送短信   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer isautosendsmsbymemregister;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer isautosendmmsbymemregister;
   /**
    * 启用会员充值发送短信   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer isautosendsmsbymemrecharge;
   /**
    * 启用会员账户提现发送短信   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer isautosendsmsbymemwithdraw;
   /**
    * 启用会员积分兑换发送短信   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer isautosendsmsbymemgiftexchange;
   /**
    * 启用会员积分变动发送短信   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer isautosendsmsbymempointchange;
   /**
    * 启用商品消费发送短信   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer isautosendsmsbycommodityconsumption;
   /**
    *  启用快速消费发送短信   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer isautosendsmsbyfastconsumption;
   /**
    * 启用会员冲次发送短信   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer isautosendsmsbymemredtimes;
   /**
    * 启用会员计时消费发送短信   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer isautosendsmsbytimingconsumption;
   /**
    * 商家支付宝账户   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String selleraccount;
   /**
    * 合作者身份(PID)   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String partnerid;
   /**
    * 合作者身份(PID)   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String partnerkey;
   /**
    * 会员重置密码时验证原始密码   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer iseditpwdneedoldpwd;
   /**
    * 公众号类型（1订阅号/2服务号）   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer weixintype;
   /**
    * 是否已认证   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer weixinverified;
   /**
    * 微信token   <br />
    * 允许为空  YES <br />
    * 数据长度 100<br />
    */
   private String weixintoken;
   /**
    * 微信ASEKEY   <br />
    * 允许为空  YES <br />
    * 数据长度 100<br />
    */
   private String weixinencodingaeskey;
   /**
    * 微信店铺名称   <br />
    * 允许为空  YES <br />
    * 数据长度 100<br />
    */
   private String weixinshopname;
   /**
    * 欢迎词   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String weixinsalutatory;
   /**
    * 微信appID   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String weixinappid;
   /**
    * 微信appSecret   <br />
    * 允许为空  YES <br />
    * 数据长度 255<br />
    */
   private String weixinappsecret;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer signinpoint;
   /**
    * 启用会员登记员工提成功能   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer ismemregisterstaff;
   /**
    * 启用会员必须刷卡消费   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer ismustslotcard;
   /**
    * 充时消费前缀   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String storagetimingprefix;
   /**
    * 启用会员充时消费发送短信   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer isautosendsmsbystoragetiming;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer enterpriseemailport;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 100<br />
    */
   private String enterpriseemaildisplayname;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer enterpriseemailenablessl;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer enterpriseemailusedefaultcredentials;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer isemail;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer isemailnotice;
   /**
    * 会员消费数量前缀   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String memcountexpenseprefix;
   /**
    * 会员到期自动发送短信   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer isautosendsmsbymempast;
   /**
    * 会员到期提醒提前天数   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer autosendsmsbymempastforday;
   /**
    * 会员生日自动发送短信   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer isautosendsmsbymembirthday;
   /**
    * 会员生日提醒提前天数   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer autosendsmsbymembirthdayforday;
   /**
    * 启用微信   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer isstartweixin;
   /**
    * 启用计时服务   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer isstarttimingproject;
   /**
    * 启用会员充次   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer isstartmemcount;
   /**
    * 启用营销短信功能   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer marketingsms;
   /**
    * 营销短信序列号   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String marketingsmsseries;
   /**
    * 营销序列号密码   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String marketingsmsserialpwd;
   /**
    * 启用感应式IC卡   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer senseiccard;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer contacticcard;
   /**
    * 邮箱用户名   <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String emailusername;
   /**
    * 打印张数设置（依次）   <br />
    * 允许为空  YES <br />
    * 数据长度 100<br />
    */
   private String pointnumstr;
   /**
    * 是否启用打印预览   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer printpreview;
   /**
    * 打印纸张类型（1:三联纸张/2:58mm纸张/3:80mm纸张）   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer printpapertype;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer issendcard;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer shopsmsmanage;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer shoppointmanage;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer shopsettlement;
   /**
    * 启用系统自动备份数据库   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer autobackupdb;
   /**
    * 间隔多久备份一次   <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer autobackupday;
   /**
    * 系统域名   <br />
    * 允许为空  YES <br />
    * 数据长度 100<br />
    */
   private String systemdomain;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 100<br />
    */
   private String mchid;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 50<br />
    */
   private String api;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 0<br />
    */
   private Integer pay;
   /**
    *    <br />
    * 允许为空  YES <br />
    * 数据长度 0 , 2<br />
    */
   private BigDecimal xiane;
   /**
    * 获得 主键<br />
    * @return parameterid<br />
    */
   public Integer getParameterid(){
     return parameterid;
   }
   
   /**
    * 设置 主键 <br />
    * @param parameterid
    */
   public void setParameterid(Integer parameterid ){
     this.parameterid=parameterid;
   }
   /**
    * 获得 启用密码验证（1启用，0禁用）<br />
    * @return pwd<br />
    */
   public Integer getPwd(){
     return pwd;
   }
   
   /**
    * 设置 启用密码验证（1启用，0禁用） <br />
    * @param pwd
    */
   public void setPwd(Integer pwd ){
     this.pwd=pwd;
   }
   /**
    * 获得 启用会员登记赠送余额及积分（1启用，0禁用）<br />
    * @return moneyandpoint<br />
    */
   public Integer getMoneyandpoint(){
     return moneyandpoint;
   }
   
   /**
    * 设置 启用会员登记赠送余额及积分（1启用，0禁用） <br />
    * @param moneyandpoint
    */
   public void setMoneyandpoint(Integer moneyandpoint ){
     this.moneyandpoint=moneyandpoint;
   }
   /**
    * 获得 启用积分转换等级 （1启用，0禁用）<br />
    * @return autolevel<br />
    */
   public Integer getAutolevel(){
     return autolevel;
   }
   
   /**
    * 设置 启用积分转换等级 （1启用，0禁用） <br />
    * @param autolevel
    */
   public void setAutolevel(Integer autolevel ){
     this.autolevel=autolevel;
   }
   /**
    * 获得 会员等级允许降级 （1启用，0禁用）<br />
    * @return degradelevel<br />
    */
   public Integer getDegradelevel(){
     return degradelevel;
   }
   
   /**
    * 设置 会员等级允许降级 （1启用，0禁用） <br />
    * @param degradelevel
    */
   public void setDegradelevel(Integer degradelevel ){
     this.degradelevel=degradelevel;
   }
   /**
    * 获得 设置会员过期时间（1启用，0禁用）<br />
    * @return pasttime<br />
    */
   public Integer getPasttime(){
     return pasttime;
   }
   
   /**
    * 设置 设置会员过期时间（1启用，0禁用） <br />
    * @param pasttime
    */
   public void setPasttime(Integer pasttime ){
     this.pasttime=pasttime;
   }
   /**
    * 获得 推荐会员获得积分（1启用，0禁用）<br />
    * @return recommendpoint<br />
    */
   public Integer getRecommendpoint(){
     return recommendpoint;
   }
   
   /**
    * 设置 推荐会员获得积分（1启用，0禁用） <br />
    * @param recommendpoint
    */
   public void setRecommendpoint(Integer recommendpoint ){
     this.recommendpoint=recommendpoint;
   }
   /**
    * 获得 积分清零提醒周期 （天数）<br />
    * @return pointperiod<br />
    */
   public Integer getPointperiod(){
     return pointperiod;
   }
   
   /**
    * 设置 积分清零提醒周期 （天数） <br />
    * @param pointperiod
    */
   public void setPointperiod(Integer pointperiod ){
     this.pointperiod=pointperiod;
   }
   /**
    * 获得 前速前缀（默认为ks）<br />
    * @return expenseprefix<br />
    */
   public String getExpenseprefix(){
     return expenseprefix;
   }
   
   /**
    * 设置 前速前缀（默认为ks） <br />
    * @param expenseprefix
    */
   public void setExpenseprefix(String expenseprefix ){
     this.expenseprefix=expenseprefix;
   }
   /**
    * 获得 商品前缀（默认为gd）<br />
    * @return goodsexpenseprefix<br />
    */
   public String getGoodsexpenseprefix(){
     return goodsexpenseprefix;
   }
   
   /**
    * 设置 商品前缀（默认为gd） <br />
    * @param goodsexpenseprefix
    */
   public void setGoodsexpenseprefix(String goodsexpenseprefix ){
     this.goodsexpenseprefix=goodsexpenseprefix;
   }
   /**
    * 获得 时间前缀（默认为gr）<br />
    * @return timeexpenseprefix<br />
    */
   public String getTimeexpenseprefix(){
     return timeexpenseprefix;
   }
   
   /**
    * 设置 时间前缀（默认为gr） <br />
    * @param timeexpenseprefix
    */
   public void setTimeexpenseprefix(String timeexpenseprefix ){
     this.timeexpenseprefix=timeexpenseprefix;
   }
   /**
    * 获得 会员充次前缀（默认为sd）<br />
    * @return memcountprefix<br />
    */
   public String getMemcountprefix(){
     return memcountprefix;
   }
   
   /**
    * 设置 会员充次前缀（默认为sd） <br />
    * @param memcountprefix
    */
   public void setMemcountprefix(String memcountprefix ){
     this.memcountprefix=memcountprefix;
   }
   /**
    * 获得 会员消费次数（默认为fd）<br />
    * @return memrechargeprefix<br />
    */
   public String getMemrechargeprefix(){
     return memrechargeprefix;
   }
   
   /**
    * 设置 会员消费次数（默认为fd） <br />
    * @param memrechargeprefix
    */
   public void setMemrechargeprefix(String memrechargeprefix ){
     this.memrechargeprefix=memrechargeprefix;
   }
   /**
    * 获得 商品前缀（默认为tt）<br />
    * @return goodsinprefix<br />
    */
   public String getGoodsinprefix(){
     return goodsinprefix;
   }
   
   /**
    * 设置 商品前缀（默认为tt） <br />
    * @param goodsinprefix
    */
   public void setGoodsinprefix(String goodsinprefix ){
     this.goodsinprefix=goodsinprefix;
   }
   /**
    * 获得 商品消费前缀（默认为gd）<br />
    * @return goodsallotprefix<br />
    */
   public String getGoodsallotprefix(){
     return goodsallotprefix;
   }
   
   /**
    * 设置 商品消费前缀（默认为gd） <br />
    * @param goodsallotprefix
    */
   public void setGoodsallotprefix(String goodsallotprefix ){
     this.goodsallotprefix=goodsallotprefix;
   }
   /**
    * 获得 会员提现前缀（默认为gd）<br />
    * @return memdrawmoneyprefix<br />
    */
   public String getMemdrawmoneyprefix(){
     return memdrawmoneyprefix;
   }
   
   /**
    * 设置 会员提现前缀（默认为gd） <br />
    * @param memdrawmoneyprefix
    */
   public void setMemdrawmoneyprefix(String memdrawmoneyprefix ){
     this.memdrawmoneyprefix=memdrawmoneyprefix;
   }
   /**
    * 获得 会员积分消费前缀（默认为gd）<br />
    * @return mempointchangeprefix<br />
    */
   public String getMempointchangeprefix(){
     return mempointchangeprefix;
   }
   
   /**
    * 设置 会员积分消费前缀（默认为gd） <br />
    * @param mempointchangeprefix
    */
   public void setMempointchangeprefix(String mempointchangeprefix ){
     this.mempointchangeprefix=mempointchangeprefix;
   }
   /**
    * 获得 礼品兑换前缀（默认为gd）<br />
    * @return giftexchangeprefix<br />
    */
   public String getGiftexchangeprefix(){
     return giftexchangeprefix;
   }
   
   /**
    * 设置 礼品兑换前缀（默认为gd） <br />
    * @param giftexchangeprefix
    */
   public void setGiftexchangeprefix(String giftexchangeprefix ){
     this.giftexchangeprefix=giftexchangeprefix;
   }
   /**
    * 获得 启用打印功能 （1启用，0禁用）<br />
    * @return autoprint<br />
    */
   public Integer getAutoprint(){
     return autoprint;
   }
   
   /**
    * 设置 启用打印功能 （1启用，0禁用） <br />
    * @param autoprint
    */
   public void setAutoprint(Integer autoprint ){
     this.autoprint=autoprint;
   }
   /**
    * 获得 是否启用打印预览（1启用，0禁用）<br />
    * @return accordprint<br />
    */
   public Integer getAccordprint(){
     return accordprint;
   }
   
   /**
    * 设置 是否启用打印预览（1启用，0禁用） <br />
    * @param accordprint
    */
   public void setAccordprint(Integer accordprint ){
     this.accordprint=accordprint;
   }
   /**
    * 获得 打印小票标题<br />
    * @return printtitle<br />
    */
   public String getPrinttitle(){
     return printtitle;
   }
   
   /**
    * 设置 打印小票标题 <br />
    * @param printtitle
    */
   public void setPrinttitle(String printtitle ){
     this.printtitle=printtitle;
   }
   /**
    * 获得 打印小票脚注<br />
    * @return printfootnote<br />
    */
   public String getPrintfootnote(){
     return printfootnote;
   }
   
   /**
    * 设置 打印小票脚注 <br />
    * @param printfootnote
    */
   public void setPrintfootnote(String printfootnote ){
     this.printfootnote=printfootnote;
   }
   /**
    * 获得 启用系统通知短信功能<br />
    * @return sms<br />
    */
   public Integer getSms(){
     return sms;
   }
   
   /**
    * 设置 启用系统通知短信功能 <br />
    * @param sms
    */
   public void setSms(Integer sms ){
     this.sms=sms;
   }
   /**
    * 获得  启用系统通知短信自动发送功能<br />
    * @return moneysms<br />
    */
   public Integer getMoneysms(){
     return moneysms;
   }
   
   /**
    * 设置  启用系统通知短信自动发送功能 <br />
    * @param moneysms
    */
   public void setMoneysms(Integer moneysms ){
     this.moneysms=moneysms;
   }
   /**
    * 获得 启用统一所有店铺短信后缀名<br />
    * @return issmsshopname<br />
    */
   public Integer getIssmsshopname(){
     return issmsshopname;
   }
   
   /**
    * 设置 启用统一所有店铺短信后缀名 <br />
    * @param issmsshopname
    */
   public void setIssmsshopname(Integer issmsshopname ){
     this.issmsshopname=issmsshopname;
   }
   /**
    * 获得 统一店铺短信后缀名<br />
    * @return smsshopname<br />
    */
   public String getSmsshopname(){
     return smsshopname;
   }
   
   /**
    * 设置 统一店铺短信后缀名 <br />
    * @param smsshopname
    */
   public void setSmsshopname(String smsshopname ){
     this.smsshopname=smsshopname;
   }
   /**
    * 获得 通知短信序列号<br />
    * @return smsseries<br />
    */
   public String getSmsseries(){
     return smsseries;
   }
   
   /**
    * 设置 通知短信序列号 <br />
    * @param smsseries
    */
   public void setSmsseries(String smsseries ){
     this.smsseries=smsseries;
   }
   /**
    * 获得 通知序列号密码<br />
    * @return smsserialpwd<br />
    */
   public String getSmsserialpwd(){
     return smsserialpwd;
   }
   
   /**
    * 设置 通知序列号密码 <br />
    * @param smsserialpwd
    */
   public void setSmsserialpwd(String smsserialpwd ){
     this.smsserialpwd=smsserialpwd;
   }
   /**
    * 获得 账户提现折损比率<br />
    * @return drawmoneypercent<br />
    */
   public Double getDrawmoneypercent(){
     return drawmoneypercent;
   }
   
   /**
    * 设置 账户提现折损比率 <br />
    * @param drawmoneypercent
    */
   public void setDrawmoneypercent(Double drawmoneypercent ){
     this.drawmoneypercent=drawmoneypercent;
   }
   /**
    * 获得 启用来电提醒功能<br />
    * @return tel<br />
    */
   public Integer getTel(){
     return tel;
   }
   
   /**
    * 设置 启用来电提醒功能 <br />
    * @param tel
    */
   public void setTel(Integer tel ){
     this.tel=tel;
   }
   /**
    * 获得 启用非会员来电提醒功能<br />
    * @return telnomember<br />
    */
   public Integer getTelnomember(){
     return telnomember;
   }
   
   /**
    * 设置 启用非会员来电提醒功能 <br />
    * @param telnomember
    */
   public void setTelnomember(Integer telnomember ){
     this.telnomember=telnomember;
   }
   /**
    * 获得 启用会员消费员工提成功能 <br />
    * @return isstaff<br />
    */
   public Integer getIsstaff(){
     return isstaff;
   }
   
   /**
    * 设置 启用会员消费员工提成功能  <br />
    * @param isstaff
    */
   public void setIsstaff(Integer isstaff ){
     this.isstaff=isstaff;
   }
   /**
    * 获得 1按员工提成比例提成\0按商品提成类型提成<br />
    * @return stafftype<br />
    */
   public Integer getStafftype(){
     return stafftype;
   }
   
   /**
    * 设置 1按员工提成比例提成\0按商品提成类型提成 <br />
    * @param stafftype
    */
   public void setStafftype(Integer stafftype ){
     this.stafftype=stafftype;
   }
   /**
    * 获得 启用会员多级积分提成<br />
    * @return pointlevel<br />
    */
   public Integer getPointlevel(){
     return pointlevel;
   }
   
   /**
    * 设置 启用会员多级积分提成 <br />
    * @param pointlevel
    */
   public void setPointlevel(Integer pointlevel ){
     this.pointlevel=pointlevel;
   }
   /**
    * 获得 <br />
    * @return mms<br />
    */
   public Integer getMms(){
     return mms;
   }
   
   /**
    * 设置  <br />
    * @param mms
    */
   public void setMms(Integer mms ){
     this.mms=mms;
   }
   /**
    * 获得 <br />
    * @return mmsseries<br />
    */
   public String getMmsseries(){
     return mmsseries;
   }
   
   /**
    * 设置  <br />
    * @param mmsseries
    */
   public void setMmsseries(String mmsseries ){
     this.mmsseries=mmsseries;
   }
   /**
    * 获得 <br />
    * @return mmsserialpwd<br />
    */
   public String getMmsserialpwd(){
     return mmsserialpwd;
   }
   
   /**
    * 设置  <br />
    * @param mmsserialpwd
    */
   public void setMmsserialpwd(String mmsserialpwd ){
     this.mmsserialpwd=mmsserialpwd;
   }
   /**
    * 获得 启用余额支付<br />
    * @return ispaycard<br />
    */
   public Integer getIspaycard(){
     return ispaycard;
   }
   
   /**
    * 设置 启用余额支付 <br />
    * @param ispaycard
    */
   public void setIspaycard(Integer ispaycard ){
     this.ispaycard=ispaycard;
   }
   /**
    * 获得 启用现金支付<br />
    * @return ispaycash<br />
    */
   public Integer getIspaycash(){
     return ispaycash;
   }
   
   /**
    * 设置 启用现金支付 <br />
    * @param ispaycash
    */
   public void setIspaycash(Integer ispaycash ){
     this.ispaycash=ispaycash;
   }
   /**
    * 获得 启用银联支付<br />
    * @return ispaybink<br />
    */
   public Integer getIspaybink(){
     return ispaybink;
   }
   
   /**
    * 设置 启用银联支付 <br />
    * @param ispaybink
    */
   public void setIspaybink(Integer ispaybink ){
     this.ispaybink=ispaybink;
   }
   /**
    * 获得 启用优惠券<br />
    * @return ispaycoupon<br />
    */
   public Integer getIspaycoupon(){
     return ispaycoupon;
   }
   
   /**
    * 设置 启用优惠券 <br />
    * @param ispaycoupon
    */
   public void setIspaycoupon(Integer ispaycoupon ){
     this.ispaycoupon=ispaycoupon;
   }
   /**
    * 获得 <br />
    * @return regnullpwd<br />
    */
   public Integer getRegnullpwd(){
     return regnullpwd;
   }
   
   /**
    * 设置  <br />
    * @param regnullpwd
    */
   public void setRegnullpwd(Integer regnullpwd ){
     this.regnullpwd=regnullpwd;
   }
   /**
    * 获得 <br />
    * @return emailadress<br />
    */
   public String getEmailadress(){
     return emailadress;
   }
   
   /**
    * 设置  <br />
    * @param emailadress
    */
   public void setEmailadress(String emailadress ){
     this.emailadress=emailadress;
   }
   /**
    * 获得 <br />
    * @return emailpwd<br />
    */
   public String getEmailpwd(){
     return emailpwd;
   }
   
   /**
    * 设置  <br />
    * @param emailpwd
    */
   public void setEmailpwd(String emailpwd ){
     this.emailpwd=emailpwd;
   }
   /**
    * 获得 <br />
    * @return emailsmtp<br />
    */
   public String getEmailsmtp(){
     return emailsmtp;
   }
   
   /**
    * 设置  <br />
    * @param emailsmtp
    */
   public void setEmailsmtp(String emailsmtp ){
     this.emailsmtp=emailsmtp;
   }
   /**
    * 获得 商品库存报警数量<br />
    * @return stockcount<br />
    */
   public Integer getStockcount(){
     return stockcount;
   }
   
   /**
    * 设置 商品库存报警数量 <br />
    * @param stockcount
    */
   public void setStockcount(Integer stockcount ){
     this.stockcount=stockcount;
   }
   /**
    * 获得 商品单位（个）<br />
    * @return unitlist<br />
    */
   public String getUnitlist(){
     return unitlist;
   }
   
   /**
    * 设置 商品单位（个） <br />
    * @param unitlist
    */
   public void setUnitlist(String unitlist ){
     this.unitlist=unitlist;
   }
   /**
    * 获得 <br />
    * @return weixinsmsvcode<br />
    */
   public Integer getWeixinsmsvcode(){
     return weixinsmsvcode;
   }
   
   /**
    * 设置  <br />
    * @param weixinsmsvcode
    */
   public void setWeixinsmsvcode(Integer weixinsmsvcode ){
     this.weixinsmsvcode=weixinsmsvcode;
   }
   /**
    * 获得 启用会员登记发送短信<br />
    * @return isautosendsmsbymemregister<br />
    */
   public Integer getIsautosendsmsbymemregister(){
     return isautosendsmsbymemregister;
   }
   
   /**
    * 设置 启用会员登记发送短信 <br />
    * @param isautosendsmsbymemregister
    */
   public void setIsautosendsmsbymemregister(Integer isautosendsmsbymemregister ){
     this.isautosendsmsbymemregister=isautosendsmsbymemregister;
   }
   /**
    * 获得 <br />
    * @return isautosendmmsbymemregister<br />
    */
   public Integer getIsautosendmmsbymemregister(){
     return isautosendmmsbymemregister;
   }
   
   /**
    * 设置  <br />
    * @param isautosendmmsbymemregister
    */
   public void setIsautosendmmsbymemregister(Integer isautosendmmsbymemregister ){
     this.isautosendmmsbymemregister=isautosendmmsbymemregister;
   }
   /**
    * 获得 启用会员充值发送短信<br />
    * @return isautosendsmsbymemrecharge<br />
    */
   public Integer getIsautosendsmsbymemrecharge(){
     return isautosendsmsbymemrecharge;
   }
   
   /**
    * 设置 启用会员充值发送短信 <br />
    * @param isautosendsmsbymemrecharge
    */
   public void setIsautosendsmsbymemrecharge(Integer isautosendsmsbymemrecharge ){
     this.isautosendsmsbymemrecharge=isautosendsmsbymemrecharge;
   }
   /**
    * 获得 启用会员账户提现发送短信<br />
    * @return isautosendsmsbymemwithdraw<br />
    */
   public Integer getIsautosendsmsbymemwithdraw(){
     return isautosendsmsbymemwithdraw;
   }
   
   /**
    * 设置 启用会员账户提现发送短信 <br />
    * @param isautosendsmsbymemwithdraw
    */
   public void setIsautosendsmsbymemwithdraw(Integer isautosendsmsbymemwithdraw ){
     this.isautosendsmsbymemwithdraw=isautosendsmsbymemwithdraw;
   }
   /**
    * 获得 启用会员积分兑换发送短信<br />
    * @return isautosendsmsbymemgiftexchange<br />
    */
   public Integer getIsautosendsmsbymemgiftexchange(){
     return isautosendsmsbymemgiftexchange;
   }
   
   /**
    * 设置 启用会员积分兑换发送短信 <br />
    * @param isautosendsmsbymemgiftexchange
    */
   public void setIsautosendsmsbymemgiftexchange(Integer isautosendsmsbymemgiftexchange ){
     this.isautosendsmsbymemgiftexchange=isautosendsmsbymemgiftexchange;
   }
   /**
    * 获得 启用会员积分变动发送短信<br />
    * @return isautosendsmsbymempointchange<br />
    */
   public Integer getIsautosendsmsbymempointchange(){
     return isautosendsmsbymempointchange;
   }
   
   /**
    * 设置 启用会员积分变动发送短信 <br />
    * @param isautosendsmsbymempointchange
    */
   public void setIsautosendsmsbymempointchange(Integer isautosendsmsbymempointchange ){
     this.isautosendsmsbymempointchange=isautosendsmsbymempointchange;
   }
   /**
    * 获得 启用商品消费发送短信<br />
    * @return isautosendsmsbycommodityconsumption<br />
    */
   public Integer getIsautosendsmsbycommodityconsumption(){
     return isautosendsmsbycommodityconsumption;
   }
   
   /**
    * 设置 启用商品消费发送短信 <br />
    * @param isautosendsmsbycommodityconsumption
    */
   public void setIsautosendsmsbycommodityconsumption(Integer isautosendsmsbycommodityconsumption ){
     this.isautosendsmsbycommodityconsumption=isautosendsmsbycommodityconsumption;
   }
   /**
    * 获得  启用快速消费发送短信<br />
    * @return isautosendsmsbyfastconsumption<br />
    */
   public Integer getIsautosendsmsbyfastconsumption(){
     return isautosendsmsbyfastconsumption;
   }
   
   /**
    * 设置  启用快速消费发送短信 <br />
    * @param isautosendsmsbyfastconsumption
    */
   public void setIsautosendsmsbyfastconsumption(Integer isautosendsmsbyfastconsumption ){
     this.isautosendsmsbyfastconsumption=isautosendsmsbyfastconsumption;
   }
   /**
    * 获得 启用会员冲次发送短信<br />
    * @return isautosendsmsbymemredtimes<br />
    */
   public Integer getIsautosendsmsbymemredtimes(){
     return isautosendsmsbymemredtimes;
   }
   
   /**
    * 设置 启用会员冲次发送短信 <br />
    * @param isautosendsmsbymemredtimes
    */
   public void setIsautosendsmsbymemredtimes(Integer isautosendsmsbymemredtimes ){
     this.isautosendsmsbymemredtimes=isautosendsmsbymemredtimes;
   }
   /**
    * 获得 启用会员计时消费发送短信<br />
    * @return isautosendsmsbytimingconsumption<br />
    */
   public Integer getIsautosendsmsbytimingconsumption(){
     return isautosendsmsbytimingconsumption;
   }
   
   /**
    * 设置 启用会员计时消费发送短信 <br />
    * @param isautosendsmsbytimingconsumption
    */
   public void setIsautosendsmsbytimingconsumption(Integer isautosendsmsbytimingconsumption ){
     this.isautosendsmsbytimingconsumption=isautosendsmsbytimingconsumption;
   }
   /**
    * 获得 商家支付宝账户<br />
    * @return selleraccount<br />
    */
   public String getSelleraccount(){
     return selleraccount;
   }
   
   /**
    * 设置 商家支付宝账户 <br />
    * @param selleraccount
    */
   public void setSelleraccount(String selleraccount ){
     this.selleraccount=selleraccount;
   }
   /**
    * 获得 合作者身份(PID)<br />
    * @return partnerid<br />
    */
   public String getPartnerid(){
     return partnerid;
   }
   
   /**
    * 设置 合作者身份(PID) <br />
    * @param partnerid
    */
   public void setPartnerid(String partnerid ){
     this.partnerid=partnerid;
   }
   /**
    * 获得 合作者身份(PID)<br />
    * @return partnerkey<br />
    */
   public String getPartnerkey(){
     return partnerkey;
   }
   
   /**
    * 设置 合作者身份(PID) <br />
    * @param partnerkey
    */
   public void setPartnerkey(String partnerkey ){
     this.partnerkey=partnerkey;
   }
   /**
    * 获得 会员重置密码时验证原始密码<br />
    * @return iseditpwdneedoldpwd<br />
    */
   public Integer getIseditpwdneedoldpwd(){
     return iseditpwdneedoldpwd;
   }
   
   /**
    * 设置 会员重置密码时验证原始密码 <br />
    * @param iseditpwdneedoldpwd
    */
   public void setIseditpwdneedoldpwd(Integer iseditpwdneedoldpwd ){
     this.iseditpwdneedoldpwd=iseditpwdneedoldpwd;
   }
   /**
    * 获得 公众号类型（1订阅号/2服务号）<br />
    * @return weixintype<br />
    */
   public Integer getWeixintype(){
     return weixintype;
   }
   
   /**
    * 设置 公众号类型（1订阅号/2服务号） <br />
    * @param weixintype
    */
   public void setWeixintype(Integer weixintype ){
     this.weixintype=weixintype;
   }
   /**
    * 获得 是否已认证<br />
    * @return weixinverified<br />
    */
   public Integer getWeixinverified(){
     return weixinverified;
   }
   
   /**
    * 设置 是否已认证 <br />
    * @param weixinverified
    */
   public void setWeixinverified(Integer weixinverified ){
     this.weixinverified=weixinverified;
   }
   /**
    * 获得 微信token<br />
    * @return weixintoken<br />
    */
   public String getWeixintoken(){
     return weixintoken;
   }
   
   /**
    * 设置 微信token <br />
    * @param weixintoken
    */
   public void setWeixintoken(String weixintoken ){
     this.weixintoken=weixintoken;
   }
   /**
    * 获得 微信ASEKEY<br />
    * @return weixinencodingaeskey<br />
    */
   public String getWeixinencodingaeskey(){
     return weixinencodingaeskey;
   }
   
   /**
    * 设置 微信ASEKEY <br />
    * @param weixinencodingaeskey
    */
   public void setWeixinencodingaeskey(String weixinencodingaeskey ){
     this.weixinencodingaeskey=weixinencodingaeskey;
   }
   /**
    * 获得 微信店铺名称<br />
    * @return weixinshopname<br />
    */
   public String getWeixinshopname(){
     return weixinshopname;
   }
   
   /**
    * 设置 微信店铺名称 <br />
    * @param weixinshopname
    */
   public void setWeixinshopname(String weixinshopname ){
     this.weixinshopname=weixinshopname;
   }
   /**
    * 获得 欢迎词<br />
    * @return weixinsalutatory<br />
    */
   public String getWeixinsalutatory(){
     return weixinsalutatory;
   }
   
   /**
    * 设置 欢迎词 <br />
    * @param weixinsalutatory
    */
   public void setWeixinsalutatory(String weixinsalutatory ){
     this.weixinsalutatory=weixinsalutatory;
   }
   /**
    * 获得 微信appID<br />
    * @return weixinappid<br />
    */
   public String getWeixinappid(){
     return weixinappid;
   }
   
   /**
    * 设置 微信appID <br />
    * @param weixinappid
    */
   public void setWeixinappid(String weixinappid ){
     this.weixinappid=weixinappid;
   }
   /**
    * 获得 微信appSecret<br />
    * @return weixinappsecret<br />
    */
   public String getWeixinappsecret(){
     return weixinappsecret;
   }
   
   /**
    * 设置 微信appSecret <br />
    * @param weixinappsecret
    */
   public void setWeixinappsecret(String weixinappsecret ){
     this.weixinappsecret=weixinappsecret;
   }
   /**
    * 获得 <br />
    * @return signinpoint<br />
    */
   public Integer getSigninpoint(){
     return signinpoint;
   }
   
   /**
    * 设置  <br />
    * @param signinpoint
    */
   public void setSigninpoint(Integer signinpoint ){
     this.signinpoint=signinpoint;
   }
   /**
    * 获得 启用会员登记员工提成功能<br />
    * @return ismemregisterstaff<br />
    */
   public Integer getIsmemregisterstaff(){
     return ismemregisterstaff;
   }
   
   /**
    * 设置 启用会员登记员工提成功能 <br />
    * @param ismemregisterstaff
    */
   public void setIsmemregisterstaff(Integer ismemregisterstaff ){
     this.ismemregisterstaff=ismemregisterstaff;
   }
   /**
    * 获得 启用会员必须刷卡消费<br />
    * @return ismustslotcard<br />
    */
   public Integer getIsmustslotcard(){
     return ismustslotcard;
   }
   
   /**
    * 设置 启用会员必须刷卡消费 <br />
    * @param ismustslotcard
    */
   public void setIsmustslotcard(Integer ismustslotcard ){
     this.ismustslotcard=ismustslotcard;
   }
   /**
    * 获得 充时消费前缀<br />
    * @return storagetimingprefix<br />
    */
   public String getStoragetimingprefix(){
     return storagetimingprefix;
   }
   
   /**
    * 设置 充时消费前缀 <br />
    * @param storagetimingprefix
    */
   public void setStoragetimingprefix(String storagetimingprefix ){
     this.storagetimingprefix=storagetimingprefix;
   }
   /**
    * 获得 启用会员充时消费发送短信<br />
    * @return isautosendsmsbystoragetiming<br />
    */
   public Integer getIsautosendsmsbystoragetiming(){
     return isautosendsmsbystoragetiming;
   }
   
   /**
    * 设置 启用会员充时消费发送短信 <br />
    * @param isautosendsmsbystoragetiming
    */
   public void setIsautosendsmsbystoragetiming(Integer isautosendsmsbystoragetiming ){
     this.isautosendsmsbystoragetiming=isautosendsmsbystoragetiming;
   }
   /**
    * 获得 <br />
    * @return enterpriseemailport<br />
    */
   public Integer getEnterpriseemailport(){
     return enterpriseemailport;
   }
   
   /**
    * 设置  <br />
    * @param enterpriseemailport
    */
   public void setEnterpriseemailport(Integer enterpriseemailport ){
     this.enterpriseemailport=enterpriseemailport;
   }
   /**
    * 获得 <br />
    * @return enterpriseemaildisplayname<br />
    */
   public String getEnterpriseemaildisplayname(){
     return enterpriseemaildisplayname;
   }
   
   /**
    * 设置  <br />
    * @param enterpriseemaildisplayname
    */
   public void setEnterpriseemaildisplayname(String enterpriseemaildisplayname ){
     this.enterpriseemaildisplayname=enterpriseemaildisplayname;
   }
   /**
    * 获得 <br />
    * @return enterpriseemailenablessl<br />
    */
   public Integer getEnterpriseemailenablessl(){
     return enterpriseemailenablessl;
   }
   
   /**
    * 设置  <br />
    * @param enterpriseemailenablessl
    */
   public void setEnterpriseemailenablessl(Integer enterpriseemailenablessl ){
     this.enterpriseemailenablessl=enterpriseemailenablessl;
   }
   /**
    * 获得 <br />
    * @return enterpriseemailusedefaultcredentials<br />
    */
   public Integer getEnterpriseemailusedefaultcredentials(){
     return enterpriseemailusedefaultcredentials;
   }
   
   /**
    * 设置  <br />
    * @param enterpriseemailusedefaultcredentials
    */
   public void setEnterpriseemailusedefaultcredentials(Integer enterpriseemailusedefaultcredentials ){
     this.enterpriseemailusedefaultcredentials=enterpriseemailusedefaultcredentials;
   }
   /**
    * 获得 <br />
    * @return isemail<br />
    */
   public Integer getIsemail(){
     return isemail;
   }
   
   /**
    * 设置  <br />
    * @param isemail
    */
   public void setIsemail(Integer isemail ){
     this.isemail=isemail;
   }
   /**
    * 获得 <br />
    * @return isemailnotice<br />
    */
   public Integer getIsemailnotice(){
     return isemailnotice;
   }
   
   /**
    * 设置  <br />
    * @param isemailnotice
    */
   public void setIsemailnotice(Integer isemailnotice ){
     this.isemailnotice=isemailnotice;
   }
   /**
    * 获得 会员消费数量前缀<br />
    * @return memcountexpenseprefix<br />
    */
   public String getMemcountexpenseprefix(){
     return memcountexpenseprefix;
   }
   
   /**
    * 设置 会员消费数量前缀 <br />
    * @param memcountexpenseprefix
    */
   public void setMemcountexpenseprefix(String memcountexpenseprefix ){
     this.memcountexpenseprefix=memcountexpenseprefix;
   }
   /**
    * 获得 会员到期自动发送短信<br />
    * @return isautosendsmsbymempast<br />
    */
   public Integer getIsautosendsmsbymempast(){
     return isautosendsmsbymempast;
   }
   
   /**
    * 设置 会员到期自动发送短信 <br />
    * @param isautosendsmsbymempast
    */
   public void setIsautosendsmsbymempast(Integer isautosendsmsbymempast ){
     this.isautosendsmsbymempast=isautosendsmsbymempast;
   }
   /**
    * 获得 会员到期提醒提前天数<br />
    * @return autosendsmsbymempastforday<br />
    */
   public Integer getAutosendsmsbymempastforday(){
     return autosendsmsbymempastforday;
   }
   
   /**
    * 设置 会员到期提醒提前天数 <br />
    * @param autosendsmsbymempastforday
    */
   public void setAutosendsmsbymempastforday(Integer autosendsmsbymempastforday ){
     this.autosendsmsbymempastforday=autosendsmsbymempastforday;
   }
   /**
    * 获得 会员生日自动发送短信<br />
    * @return isautosendsmsbymembirthday<br />
    */
   public Integer getIsautosendsmsbymembirthday(){
     return isautosendsmsbymembirthday;
   }
   
   /**
    * 设置 会员生日自动发送短信 <br />
    * @param isautosendsmsbymembirthday
    */
   public void setIsautosendsmsbymembirthday(Integer isautosendsmsbymembirthday ){
     this.isautosendsmsbymembirthday=isautosendsmsbymembirthday;
   }
   /**
    * 获得 会员生日提醒提前天数<br />
    * @return autosendsmsbymembirthdayforday<br />
    */
   public Integer getAutosendsmsbymembirthdayforday(){
     return autosendsmsbymembirthdayforday;
   }
   
   /**
    * 设置 会员生日提醒提前天数 <br />
    * @param autosendsmsbymembirthdayforday
    */
   public void setAutosendsmsbymembirthdayforday(Integer autosendsmsbymembirthdayforday ){
     this.autosendsmsbymembirthdayforday=autosendsmsbymembirthdayforday;
   }
   /**
    * 获得 启用微信<br />
    * @return isstartweixin<br />
    */
   public Integer getIsstartweixin(){
     return isstartweixin;
   }
   
   /**
    * 设置 启用微信 <br />
    * @param isstartweixin
    */
   public void setIsstartweixin(Integer isstartweixin ){
     this.isstartweixin=isstartweixin;
   }
   /**
    * 获得 启用计时服务<br />
    * @return isstarttimingproject<br />
    */
   public Integer getIsstarttimingproject(){
     return isstarttimingproject;
   }
   
   /**
    * 设置 启用计时服务 <br />
    * @param isstarttimingproject
    */
   public void setIsstarttimingproject(Integer isstarttimingproject ){
     this.isstarttimingproject=isstarttimingproject;
   }
   /**
    * 获得 启用会员充次<br />
    * @return isstartmemcount<br />
    */
   public Integer getIsstartmemcount(){
     return isstartmemcount;
   }
   
   /**
    * 设置 启用会员充次 <br />
    * @param isstartmemcount
    */
   public void setIsstartmemcount(Integer isstartmemcount ){
     this.isstartmemcount=isstartmemcount;
   }
   /**
    * 获得 启用营销短信功能<br />
    * @return marketingsms<br />
    */
   public Integer getMarketingsms(){
     return marketingsms;
   }
   
   /**
    * 设置 启用营销短信功能 <br />
    * @param marketingsms
    */
   public void setMarketingsms(Integer marketingsms ){
     this.marketingsms=marketingsms;
   }
   /**
    * 获得 营销短信序列号<br />
    * @return marketingsmsseries<br />
    */
   public String getMarketingsmsseries(){
     return marketingsmsseries;
   }
   
   /**
    * 设置 营销短信序列号 <br />
    * @param marketingsmsseries
    */
   public void setMarketingsmsseries(String marketingsmsseries ){
     this.marketingsmsseries=marketingsmsseries;
   }
   /**
    * 获得 营销序列号密码<br />
    * @return marketingsmsserialpwd<br />
    */
   public String getMarketingsmsserialpwd(){
     return marketingsmsserialpwd;
   }
   
   /**
    * 设置 营销序列号密码 <br />
    * @param marketingsmsserialpwd
    */
   public void setMarketingsmsserialpwd(String marketingsmsserialpwd ){
     this.marketingsmsserialpwd=marketingsmsserialpwd;
   }
   /**
    * 获得 启用感应式IC卡<br />
    * @return senseiccard<br />
    */
   public Integer getSenseiccard(){
     return senseiccard;
   }
   
   /**
    * 设置 启用感应式IC卡 <br />
    * @param senseiccard
    */
   public void setSenseiccard(Integer senseiccard ){
     this.senseiccard=senseiccard;
   }
   /**
    * 获得 <br />
    * @return contacticcard<br />
    */
   public Integer getContacticcard(){
     return contacticcard;
   }
   
   /**
    * 设置  <br />
    * @param contacticcard
    */
   public void setContacticcard(Integer contacticcard ){
     this.contacticcard=contacticcard;
   }
   /**
    * 获得 邮箱用户名<br />
    * @return emailusername<br />
    */
   public String getEmailusername(){
     return emailusername;
   }
   
   /**
    * 设置 邮箱用户名 <br />
    * @param emailusername
    */
   public void setEmailusername(String emailusername ){
     this.emailusername=emailusername;
   }
   /**
    * 获得 打印张数设置（依次）<br />
    * @return pointnumstr<br />
    */
   public String getPointnumstr(){
     return pointnumstr;
   }
   
   /**
    * 设置 打印张数设置（依次） <br />
    * @param pointnumstr
    */
   public void setPointnumstr(String pointnumstr ){
     this.pointnumstr=pointnumstr;
   }
   /**
    * 获得 是否启用打印预览<br />
    * @return printpreview<br />
    */
   public Integer getPrintpreview(){
     return printpreview;
   }
   
   /**
    * 设置 是否启用打印预览 <br />
    * @param printpreview
    */
   public void setPrintpreview(Integer printpreview ){
     this.printpreview=printpreview;
   }
   /**
    * 获得 打印纸张类型（1:三联纸张/2:58mm纸张/3:80mm纸张）<br />
    * @return printpapertype<br />
    */
   public Integer getPrintpapertype(){
     return printpapertype;
   }
   
   /**
    * 设置 打印纸张类型（1:三联纸张/2:58mm纸张/3:80mm纸张） <br />
    * @param printpapertype
    */
   public void setPrintpapertype(Integer printpapertype ){
     this.printpapertype=printpapertype;
   }
   /**
    * 获得 <br />
    * @return issendcard<br />
    */
   public Integer getIssendcard(){
     return issendcard;
   }
   
   /**
    * 设置  <br />
    * @param issendcard
    */
   public void setIssendcard(Integer issendcard ){
     this.issendcard=issendcard;
   }
   /**
    * 获得 <br />
    * @return shopsmsmanage<br />
    */
   public Integer getShopsmsmanage(){
     return shopsmsmanage;
   }
   
   /**
    * 设置  <br />
    * @param shopsmsmanage
    */
   public void setShopsmsmanage(Integer shopsmsmanage ){
     this.shopsmsmanage=shopsmsmanage;
   }
   /**
    * 获得 <br />
    * @return shoppointmanage<br />
    */
   public Integer getShoppointmanage(){
     return shoppointmanage;
   }
   
   /**
    * 设置  <br />
    * @param shoppointmanage
    */
   public void setShoppointmanage(Integer shoppointmanage ){
     this.shoppointmanage=shoppointmanage;
   }
   /**
    * 获得 <br />
    * @return shopsettlement<br />
    */
   public Integer getShopsettlement(){
     return shopsettlement;
   }
   
   /**
    * 设置  <br />
    * @param shopsettlement
    */
   public void setShopsettlement(Integer shopsettlement ){
     this.shopsettlement=shopsettlement;
   }
   /**
    * 获得 启用系统自动备份数据库<br />
    * @return autobackupdb<br />
    */
   public Integer getAutobackupdb(){
     return autobackupdb;
   }
   
   /**
    * 设置 启用系统自动备份数据库 <br />
    * @param autobackupdb
    */
   public void setAutobackupdb(Integer autobackupdb ){
     this.autobackupdb=autobackupdb;
   }
   /**
    * 获得 间隔多久备份一次<br />
    * @return autobackupday<br />
    */
   public Integer getAutobackupday(){
     return autobackupday;
   }
   
   /**
    * 设置 间隔多久备份一次 <br />
    * @param autobackupday
    */
   public void setAutobackupday(Integer autobackupday ){
     this.autobackupday=autobackupday;
   }
   /**
    * 获得 系统域名<br />
    * @return systemdomain<br />
    */
   public String getSystemdomain(){
     return systemdomain;
   }
   
   /**
    * 设置 系统域名 <br />
    * @param systemdomain
    */
   public void setSystemdomain(String systemdomain ){
     this.systemdomain=systemdomain;
   }
   /**
    * 获得 <br />
    * @return mchid<br />
    */
   public String getMchid(){
     return mchid;
   }
   
   /**
    * 设置  <br />
    * @param mchid
    */
   public void setMchid(String mchid ){
     this.mchid=mchid;
   }
   /**
    * 获得 <br />
    * @return api<br />
    */
   public String getApi(){
     return api;
   }
   
   /**
    * 设置  <br />
    * @param api
    */
   public void setApi(String api ){
     this.api=api;
   }
   /**
    * 获得 <br />
    * @return pay<br />
    */
   public Integer getPay(){
     return pay;
   }
   
   /**
    * 设置  <br />
    * @param pay
    */
   public void setPay(Integer pay ){
     this.pay=pay;
   }
   /**
    * 获得 <br />
    * @return xiane<br />
    */
   public BigDecimal getXiane(){
     return xiane;
   }
   
   /**
    * 设置  <br />
    * @param xiane
    */
   public void setXiane(BigDecimal xiane ){
     this.xiane=xiane;
   }
}
