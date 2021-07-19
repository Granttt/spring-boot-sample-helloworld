package com.activities;
import java.util.Date;
import java.io.Serializable;

/**
 * @文件名称：CrmInvoiceReOrderInfo.java
 * @创建时间：2021-06-30 17:28:04
 * @创  建  人：gxy 
 * @文件描述：订单关联发票信息实体类
 * @文件版本：V0.01 
 */
public class CrmInvoiceReOrderInfo implements Serializable {
	private Integer id;
	/**
	 * 关联订单id
	 */
	private Integer orderId;
	/**
	 * 订单类型 1储值 2充值 5积分
	 */
	private Short orderType;
	/**
	 * 订单开票状态
	 */
	private Short invoiceState;
	/**
	 * 客户id
	 */
	private Integer customerId;
	/**
	 * 客户名称
	 */
	private String customerName;
	/**
	 * 对应开票公司id
	 */
	private Integer contractCompanyId;
	/**
	 * 对应开票公司名称
	 */
	private String contractCompanyName;
	/**
	 * 回款总额
	 */
	private Integer returnAmount;
	/**
	 * 退售回款额
	 */
	private Integer refundReturnAmout;
	/**
	 * 可开票总额
	 */
	private Integer totalInvoiceAmount;
	/**
	 * 已开票金额
	 */
	private Integer usedInvoiceAmount;
	/**
	 * 剩余可开票总额
	 */
	private Integer leftInvoiceAmount;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	private Date gmtModified;
	/**
	 * 创建人
	 */
	private Integer creator;
	/**
	 * 创建人名称
	 */
	private String creatorName;
	/**
	 * 创建人部门
	 */
	private Integer departmentId;
	/**
	 * 创建人部门名称
	 */
	private String departmentName;
	/**
	 * 操作人
	 */
	private Integer operator;
	/**
	 * 归属人
	 */
	private Integer ownerUserId;
	/**
	 * 归属人名称
	 */
	private String ownerUserName;
	/**
	 * 归属人部门
	 */
	private Integer ownerDepartmentId;
	/**
	 * 归属人部门名称
	 */
	private String ownerDepartmentName;
	public void setId(Integer id){
	this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setOrderId(Integer orderId){
	this.orderId = orderId;
	}
	public Integer getOrderId(){
		return orderId;
	}
	public void setOrderType(Short orderType){
	this.orderType = orderType;
	}
	public Short getOrderType(){
		return orderType;
	}
	public void setInvoiceState(Short invoiceState){
	this.invoiceState = invoiceState;
	}
	public Short getInvoiceState(){
		return invoiceState;
	}
	public void setCustomerId(Integer customerId){
	this.customerId = customerId;
	}
	public Integer getCustomerId(){
		return customerId;
	}
	public void setCustomerName(String customerName){
	this.customerName = customerName;
	}
	public String getCustomerName(){
		return customerName;
	}
	public void setContractCompanyId(Integer contractCompanyId){
	this.contractCompanyId = contractCompanyId;
	}
	public Integer getContractCompanyId(){
		return contractCompanyId;
	}
	public void setContractCompanyName(String contractCompanyName){
	this.contractCompanyName = contractCompanyName;
	}
	public String getContractCompanyName(){
		return contractCompanyName;
	}
	public void setReturnAmount(Integer returnAmount){
	this.returnAmount = returnAmount;
	}
	public Integer getReturnAmount(){
		return returnAmount;
	}
	public void setRefundReturnAmout(Integer refundReturnAmout){
	this.refundReturnAmout = refundReturnAmout;
	}
	public Integer getRefundReturnAmout(){
		return refundReturnAmout;
	}
	public void setTotalInvoiceAmount(Integer totalInvoiceAmount){
	this.totalInvoiceAmount = totalInvoiceAmount;
	}
	public Integer getTotalInvoiceAmount(){
		return totalInvoiceAmount;
	}
	public void setUsedInvoiceAmount(Integer usedInvoiceAmount){
	this.usedInvoiceAmount = usedInvoiceAmount;
	}
	public Integer getUsedInvoiceAmount(){
		return usedInvoiceAmount;
	}
	public void setLeftInvoiceAmount(Integer leftInvoiceAmount){
	this.leftInvoiceAmount = leftInvoiceAmount;
	}
	public Integer getLeftInvoiceAmount(){
		return leftInvoiceAmount;
	}
	public void setGmtCreate(Date gmtCreate){
	this.gmtCreate = gmtCreate;
	}
	public Date getGmtCreate(){
		return gmtCreate;
	}
	public void setGmtModified(Date gmtModified){
	this.gmtModified = gmtModified;
	}
	public Date getGmtModified(){
		return gmtModified;
	}
	public void setCreator(Integer creator){
	this.creator = creator;
	}
	public Integer getCreator(){
		return creator;
	}
	public void setCreatorName(String creatorName){
	this.creatorName = creatorName;
	}
	public String getCreatorName(){
		return creatorName;
	}
	public void setDepartmentId(Integer departmentId){
	this.departmentId = departmentId;
	}
	public Integer getDepartmentId(){
		return departmentId;
	}
	public void setDepartmentName(String departmentName){
	this.departmentName = departmentName;
	}
	public String getDepartmentName(){
		return departmentName;
	}
	public void setOperator(Integer operator){
	this.operator = operator;
	}
	public Integer getOperator(){
		return operator;
	}
	public void setOwnerUserId(Integer ownerUserId){
	this.ownerUserId = ownerUserId;
	}
	public Integer getOwnerUserId(){
		return ownerUserId;
	}
	public void setOwnerUserName(String ownerUserName){
	this.ownerUserName = ownerUserName;
	}
	public String getOwnerUserName(){
		return ownerUserName;
	}
	public void setOwnerDepartmentId(Integer ownerDepartmentId){
	this.ownerDepartmentId = ownerDepartmentId;
	}
	public Integer getOwnerDepartmentId(){
		return ownerDepartmentId;
	}
	public void setOwnerDepartmentName(String ownerDepartmentName){
	this.ownerDepartmentName = ownerDepartmentName;
	}
	public String getOwnerDepartmentName(){
		return ownerDepartmentName;
	}
}

