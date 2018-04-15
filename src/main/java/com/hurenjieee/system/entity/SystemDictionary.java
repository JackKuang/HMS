package com.hurenjieee.system.entity;

import java.util.Date;
import javax.persistence.*;

import com.hurenjieee.core.annotation.AutoInjection;
import com.hurenjieee.core.annotation.InjectionType;
import com.hurenjieee.core.entity.BaseEntity;


/**
 * @Description: 数据字典
 * @Author: JackKuang
 * @Since: 2018年4月15日下午5:27:55  
 */
@Table(name = "system_dictionary")
public class SystemDictionary extends BaseEntity {

    @AutoInjection(type = InjectionType.CREATE_USER)
    @Column(name = "create_user")
    private String createUser;

    @AutoInjection(type = InjectionType.CREATE_DATE)
    @Column(name = "create_date")
    private Date createDate;

    @AutoInjection(type = InjectionType.UPDATE_USER)
    @Column(name = "update_user")
    private String updateUser;

    @AutoInjection(type = InjectionType.UPDATE_DATE)
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 数据字典名称
     */
    @Column(name = "dictionary_name")
    private String dictionaryName;

    /**
     * 数据字典Key
     */
    @Column(name = "dictionary_key")
    private String dictionaryKey;

    /**
     * 数据字典value
     */
    @Column(name = "dictionary_value")
    private String dictionaryValue;

    /**
     * 数据字典父节点uuid
     */
    @Column(name = "dictionary_par_uuid")
    private String dictionaryParUuid;

    /**
     * 数据字典排序
     */
    @Column(name = "dictionary_order")
    private Integer dictionaryOrder;

    /**
     * 数据字典状态
     */
    @Column(name = "dictionary_state")
    private Integer dictionaryState;

    /**
     * @return create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return update_user
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * @param updateUser
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * @return update_date
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取数据字典名称
     *
     * @return dictionary_name - 数据字典名称
     */
    public String getDictionaryName() {
        return dictionaryName;
    }

    /**
     * 设置数据字典名称
     *
     * @param dictionaryName 数据字典名称
     */
    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName;
    }

    /**
     * 获取数据字典Key
     *
     * @return dictionary_key - 数据字典Key
     */
    public String getDictionaryKey() {
        return dictionaryKey;
    }

    /**
     * 设置数据字典Key
     *
     * @param dictionaryKey 数据字典Key
     */
    public void setDictionaryKey(String dictionaryKey) {
        this.dictionaryKey = dictionaryKey;
    }

    /**
     * 获取数据字典value
     *
     * @return dictionary_value - 数据字典value
     */
    public String getDictionaryValue() {
        return dictionaryValue;
    }

    /**
     * 设置数据字典value
     *
     * @param dictionaryValue 数据字典value
     */
    public void setDictionaryValue(String dictionaryValue) {
        this.dictionaryValue = dictionaryValue;
    }

    /**
     * 获取数据字典父节点uuid
     *
     * @return dictionary_par_uuid - 数据字典父节点uuid
     */
    public String getDictionaryParUuid() {
        return dictionaryParUuid;
    }

    /**
     * 设置数据字典父节点uuid
     *
     * @param dictionaryParUuid 数据字典父节点uuid
     */
    public void setDictionaryParUuid(String dictionaryParUuid) {
        this.dictionaryParUuid = dictionaryParUuid;
    }

    /**
     * 获取数据字典排序
     *
     * @return dictionary_order - 数据字典排序
     */
    public Integer getDictionaryOrder() {
        return dictionaryOrder;
    }

    /**
     * 设置数据字典排序
     *
     * @param dictionaryOrder 数据字典排序
     */
    public void setDictionaryOrder(Integer dictionaryOrder) {
        this.dictionaryOrder = dictionaryOrder;
    }

    /**
     * 获取数据字典状态
     *
     * @return dictionary_state - 数据字典状态
     */
    public Integer getDictionaryState() {
        return dictionaryState;
    }

    /**
     * 设置数据字典状态
     *
     * @param dictionaryState 数据字典状态
     */
    public void setDictionaryState(Integer dictionaryState) {
        this.dictionaryState = dictionaryState;
    }
}