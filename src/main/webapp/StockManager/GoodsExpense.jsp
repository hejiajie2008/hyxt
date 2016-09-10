<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="/WEB-INF/utils.tld" prefix="utils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="ks-trident7 ks-trident ks-ie11 ks-ie">
<head>
<title></title>
<link href="../Inc/Style/Style.css" rel="stylesheet" type="text/css" />
<link href="../Inc/artDialogskins/blue.css" rel="stylesheet"
	type="text/css" />
<script src="../Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
<script src="../Scripts/jquery-common.js" type="text/javascript"></script>
<script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
<script src="../Scripts/LodopFuncs.js" type="text/javascript"></script>
<script src="../Scripts/jquery.artDialog.basic.js"
	type="text/javascript"></script>
<script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
<script src="../Scripts/Module/StockManage/GoodsExpense.js"
	type="text/javascript"></script>
<script src="../Scripts/My97DatePicker/WdatePicker.js"
	type="text/javascript"></script>
<script src="../Scripts/Module/Report/Print.js" type="text/javascript"></script>
<script type="text/javascript">
	var _sys_check = {
		reg : function(a) {
			var b = Math.abs(a);
			switch (b) {
			case 0:
				partten = "^\\d+$";
				break;
			default:
				partten = "^\\d+(?:\\.\\d{1," + b + "})?$";
				break;
			}
			return new RegExp(partten);
		},
		defval : 0.01
	};
	var sys_num_checked = {
		product_num_check : function(a) {
			var reg = _sys_check.reg(2);
			return reg.test(a);
		},
		product_num : function(a) {
			if (Math.abs(2) > 0) {
				var b = a.replace(/\s/g, "");
				if ((/^\d+\.$/).test(b))
					return b + "0";
				else
					return a;
			} else
				return a;
		}
	};
</script>
</head>

<body>
	<form id="ftmGoodsExpense">
		<table style="width: 100%; height: 100%; word-wrap: break-word;"
			cellspacing="7">
			<tr>
				<td colspan="2" style="width: 100%;">
					<div class="system_Info">
						<input type="hidden" value="" id="PointNum" />
						<div class="system_Top">
							<div class="user_regist_title">
								<utils:title/>
							</div>
						</div>
						<div style="margin: 10px;">
							<jsp:include page="../Controls/Pay.jsp">
								<jsp:param value="ucPay_" name="pay" />
							</jsp:include>
						</div>
						<div class="user_List_All">
							<jsp:include page="../Controls/MemberSearch.jsp"/>
							<input id="MemCard" type="hidden" />
							<table
								style="width: 44.5%; height: 100%; border: 1px #6eb5fb solid; text-align: center; float: left;"
								cellpadding="0" cellspacing="0">
								<tr>
									<td class="tableStyle_left">商品名称或简码：</td>
									<td class="tableStyle_right"><input type="text"
										id="txtGoodsCode" class="border_radius" onkeypress="getKey();" />
										<div class="user_List_Button">
											<input type="button" value="搜索"
												class="common_Button button_style" id="btnGoodsSearch" />
										</div></td>
								</tr>
								<tr>
									<td class="tableStyle_left">扫描枪快速定位：</td>
									<td class="tableStyle_right"><input type="text"
										id="txtGoodsExpenseCode" class="border_radius" />&nbsp;&nbsp;
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<div class="tab_consume expense">
											<div class="tab-body">
												<div class="tab-pal">
													<table class="table-style table-hover" style="width: 100%">
														<thead class="thead">
															<tr class="th">
																<th style="width: 120px">商品名称</th>
																<th style="width: 40px">销售单价</th>
																<th style="width: 40px">库存数量</th>
																<th style="width: 40px">折后价格</th>
															</tr>
														</thead>
														<tbody id="tbGoodsProduct">
															<tr class="td">
																<td colspan="4"
																	style="height: 25px; text-align: center; line-height: 25px; background-color: #FFF;">
																</td>
															</tr>
														</tbody>
													</table>
													<div id="GoodsProductPage"
														style="margin: 0px; border: solid 1px #ccc; height: 30px; line-height: 30px; padding-right: 2px;">
														<div class="listTablePage_simple"></div>
													</div>
												</div>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td colspan="2"
										style="background: #e0f0ff; height: 26px; border-top: 1px solid #adadad; color: #d38117;">
										点击商品即可轻松选定，也可以通过名称或简码进行搜索或条码直接定位！</td>
								</tr>
							</table>
							<table
								style="width: 55%; height: 100%; border: 1px #6eb5fb solid; text-align: center; float: right;"
								cellpadding="0" cellspacing="0">
								<tr>
									<td class="tableStyle_left">订单编号：</td>
									<td class="tableStyle_right"><label id="spOrderAccount"
										style="font-size: 14px; font-weight: bold;"> <utils:order
												type="2" />
									</label></td>
									<td class="tableStyle_left">操作人员：</td>
									<td class="tableStyle_right"><label id="lblExpenseUSer"
										style="font-size: 14px; font-weight: bold;"> <shiro:principal />
									</label></td>
								</tr>
								<tr>
									<td class="tableStyle_left">消费日期：</td>
									<td class="tableStyle_right"><input id="txtExpenseTime"
										type="text" class="Wdate border_radius" /></td>
									<td class="tableStyle_left" id="tdStaff">员工提成：</td>
									<td class="tableStyle_right" id="tddStaff"><select
										id="sltStaff" class="selectWidth" style="width: 100px">
									</select></td>
								</tr>
								<tr>
									<td colspan="4">
										<table class="table-style user_List_txt" style="width: 100%">
											<thead class="thead">
												<tr class="th">
													<th>商品名称</th>
													<%-- <th>
                                                    商品类型
                                                </th>--%>
													<th>商品单价</th>
													<th>商品数量</th>
													<th>折后金额</th>
													<th>商品积分</th>
													<th id="thStaff">提成员工</th>
													<th>操&nbsp;作</th>
												</tr>
											</thead>
											<tbody id="tbOrderTable">
												<tr class="td">
													<td colspan="8"
														style="height: 25px; text-align: center; line-height: 25px; background-color: #FFF;">
														&nbsp;&nbsp;&nbsp;&nbsp;请点击左侧商品列表，选择需要消费的商品！</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td colspan="4">
										<table style="width: 100%; height: 100%; text-align: center;"
											cellpadding="0" cellspacing="0">
											<tr>
												<td class="tableStyle_left">消费总数量：</td>
												<td class="tableStyle_right">
													<div class="sum_num">
														<label id="lblTotalNumber"
															style="font-size: 14px; font-weight: bold;"> </label>
													</div>
												</td>
												<td class="tableStyle_left">消费总金额：</td>
												<td class="tableStyle_right">
													<div class="sum_num">
														<label id="lblTotalMoney"
															style="font-size: 14px; font-weight: bold;"> </label>
													</div>
												</td>
												<td class="tableStyle_left">折后总金额：</td>
												<td class="tableStyle_right">
													<div class="sum_num">
														<label id="lblTotalDiscountMoney"
															style="font-size: 14px; font-weight: bold;"> </label>
													</div>
												</td>
											</tr>
											<tr>
												<td class="tableStyle_left">消费总积分：</td>
												<td class="tableStyle_right">
													<div class="sum_num">
														<label id="lblTotalPoint"
															style="font-size: 14px; font-weight: bold;"> </label>
													</div>
												</td>
												<td class="tableStyle_left">提成总金额：</td>
												<td class="tableStyle_right">
													<div class="sum_num">
														<label id="lblStaffMoney"
															style="font-size: 14px; font-weight: bold;"> </label>
													</div>
												</td>
												<td class="tableStyle_left"></td>
												<td class="tableStyle_left"></td>
											</tr>
											<tr>
												<td class="tableStyle_left">消费备注：</td>
												<td colspan="5" class="tableStyle_right"><input
													type="text" id="txtExRemark"
													class="border_radius border_radius4" maxlength="50" /></td>
											</tr>
											<tr>
												<td colspan="6" style="text-align: center; height: 36px">
													<div class="submit_detail" style="text-align: center">
														<%
															//bolAutoSendSMSByCommodityConsumption

															if (com.jfxy.listener.MemoryListener.sysparameter.getSms() == 1) {
														%>
														<label style="vertical-align: text-bottom;"> <label
															class="lbsetCk" style="vertical-align: middle;">
																<input id="chkSMS" type="checkbox" /> 发送短信
														</label></label>&nbsp;&nbsp;
														<%
															}
															if (com.jfxy.listener.MemoryListener.sysparameter.getAutoprint() == 1) {
														%>
														<label style="vertical-align: text-bottom;"> <label
															class="lbsetCk" style="vertical-align: middle;">
																<input id="chkPrint" type="checkbox" /> 打印小票
														</label></label>&nbsp;&nbsp;
														<%
															}
														%>
														<input id="btnExpenseSave" type="button"
															class="buttonColor" value="结算" /> &nbsp;&nbsp; <input
															id="btnEntryOrder" type="button" class="buttonColor"
															value="挂单" visible="false" /> <input id="chkAllowPwd"
															type="checkbox" style="display: none" /> <input
															id="chkStaff" type="checkbox" style="display: none" />
														<input id="txtStaffType" type="text" style="display: none"
															value="0" /> <input id="txtOrderID" type="text"
															style="display: none" />
													</div>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</div>
						<Label ID="lblPrintTitle" Style="display: none" Text="Label"></Label>
						<Label ID="lblPrintFoot" Style="display: none" Text="Labe2"></Label>
						<input id="ShopID" type="hidden" />
					</div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
