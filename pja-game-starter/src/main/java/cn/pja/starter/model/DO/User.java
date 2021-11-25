package cn.pja.starter.model.DO;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * 
     */
    private String host;

    /**
     * 
     */
    private String user;

    /**
     * 
     */
    private String selectPriv;

    /**
     * 
     */
    private String insertPriv;

    /**
     * 
     */
    private String updatePriv;

    /**
     * 
     */
    private String deletePriv;

    /**
     * 
     */
    private String createPriv;

    /**
     * 
     */
    private String dropPriv;

    /**
     * 
     */
    private String reloadPriv;

    /**
     * 
     */
    private String shutdownPriv;

    /**
     * 
     */
    private String processPriv;

    /**
     * 
     */
    private String filePriv;

    /**
     * 
     */
    private String grantPriv;

    /**
     * 
     */
    private String referencesPriv;

    /**
     * 
     */
    private String indexPriv;

    /**
     * 
     */
    private String alterPriv;

    /**
     * 
     */
    private String showDbPriv;

    /**
     * 
     */
    private String superPriv;

    /**
     * 
     */
    private String createTmpTablePriv;

    /**
     * 
     */
    private String lockTablesPriv;

    /**
     * 
     */
    private String executePriv;

    /**
     * 
     */
    private String replSlavePriv;

    /**
     * 
     */
    private String replClientPriv;

    /**
     * 
     */
    private String createViewPriv;

    /**
     * 
     */
    private String showViewPriv;

    /**
     * 
     */
    private String createRoutinePriv;

    /**
     * 
     */
    private String alterRoutinePriv;

    /**
     * 
     */
    private String createUserPriv;

    /**
     * 
     */
    private String eventPriv;

    /**
     * 
     */
    private String triggerPriv;

    /**
     * 
     */
    private String createTablespacePriv;

    /**
     * 
     */
    private String sslType;

    /**
     * 
     */
    private Integer maxQuestions;

    /**
     * 
     */
    private Integer maxUpdates;

    /**
     * 
     */
    private Integer maxConnections;

    /**
     * 
     */
    private Integer maxUserConnections;

    /**
     * 
     */
    private String plugin;

    /**
     * 
     */
    private String passwordExpired;

    /**
     * 
     */
    private Date passwordLastChanged;

    /**
     * 
     */
    private Short passwordLifetime;

    /**
     * 
     */
    private String accountLocked;

    /**
     * user
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return Host 
     */
    public String getHost() {
        return host;
    }

    /**
     * 
     * @param host 
     */
    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    /**
     * 
     * @return User 
     */
    public String getUser() {
        return user;
    }

    /**
     * 
     * @param user 
     */
    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    /**
     * 
     * @return Select_priv 
     */
    public String getSelectPriv() {
        return selectPriv;
    }

    /**
     * 
     * @param selectPriv 
     */
    public void setSelectPriv(String selectPriv) {
        this.selectPriv = selectPriv == null ? null : selectPriv.trim();
    }

    /**
     * 
     * @return Insert_priv 
     */
    public String getInsertPriv() {
        return insertPriv;
    }

    /**
     * 
     * @param insertPriv 
     */
    public void setInsertPriv(String insertPriv) {
        this.insertPriv = insertPriv == null ? null : insertPriv.trim();
    }

    /**
     * 
     * @return Update_priv 
     */
    public String getUpdatePriv() {
        return updatePriv;
    }

    /**
     * 
     * @param updatePriv 
     */
    public void setUpdatePriv(String updatePriv) {
        this.updatePriv = updatePriv == null ? null : updatePriv.trim();
    }

    /**
     * 
     * @return Delete_priv 
     */
    public String getDeletePriv() {
        return deletePriv;
    }

    /**
     * 
     * @param deletePriv 
     */
    public void setDeletePriv(String deletePriv) {
        this.deletePriv = deletePriv == null ? null : deletePriv.trim();
    }

    /**
     * 
     * @return Create_priv 
     */
    public String getCreatePriv() {
        return createPriv;
    }

    /**
     * 
     * @param createPriv 
     */
    public void setCreatePriv(String createPriv) {
        this.createPriv = createPriv == null ? null : createPriv.trim();
    }

    /**
     * 
     * @return Drop_priv 
     */
    public String getDropPriv() {
        return dropPriv;
    }

    /**
     * 
     * @param dropPriv 
     */
    public void setDropPriv(String dropPriv) {
        this.dropPriv = dropPriv == null ? null : dropPriv.trim();
    }

    /**
     * 
     * @return Reload_priv 
     */
    public String getReloadPriv() {
        return reloadPriv;
    }

    /**
     * 
     * @param reloadPriv 
     */
    public void setReloadPriv(String reloadPriv) {
        this.reloadPriv = reloadPriv == null ? null : reloadPriv.trim();
    }

    /**
     * 
     * @return Shutdown_priv 
     */
    public String getShutdownPriv() {
        return shutdownPriv;
    }

    /**
     * 
     * @param shutdownPriv 
     */
    public void setShutdownPriv(String shutdownPriv) {
        this.shutdownPriv = shutdownPriv == null ? null : shutdownPriv.trim();
    }

    /**
     * 
     * @return Process_priv 
     */
    public String getProcessPriv() {
        return processPriv;
    }

    /**
     * 
     * @param processPriv 
     */
    public void setProcessPriv(String processPriv) {
        this.processPriv = processPriv == null ? null : processPriv.trim();
    }

    /**
     * 
     * @return File_priv 
     */
    public String getFilePriv() {
        return filePriv;
    }

    /**
     * 
     * @param filePriv 
     */
    public void setFilePriv(String filePriv) {
        this.filePriv = filePriv == null ? null : filePriv.trim();
    }

    /**
     * 
     * @return Grant_priv 
     */
    public String getGrantPriv() {
        return grantPriv;
    }

    /**
     * 
     * @param grantPriv 
     */
    public void setGrantPriv(String grantPriv) {
        this.grantPriv = grantPriv == null ? null : grantPriv.trim();
    }

    /**
     * 
     * @return References_priv 
     */
    public String getReferencesPriv() {
        return referencesPriv;
    }

    /**
     * 
     * @param referencesPriv 
     */
    public void setReferencesPriv(String referencesPriv) {
        this.referencesPriv = referencesPriv == null ? null : referencesPriv.trim();
    }

    /**
     * 
     * @return Index_priv 
     */
    public String getIndexPriv() {
        return indexPriv;
    }

    /**
     * 
     * @param indexPriv 
     */
    public void setIndexPriv(String indexPriv) {
        this.indexPriv = indexPriv == null ? null : indexPriv.trim();
    }

    /**
     * 
     * @return Alter_priv 
     */
    public String getAlterPriv() {
        return alterPriv;
    }

    /**
     * 
     * @param alterPriv 
     */
    public void setAlterPriv(String alterPriv) {
        this.alterPriv = alterPriv == null ? null : alterPriv.trim();
    }

    /**
     * 
     * @return Show_db_priv 
     */
    public String getShowDbPriv() {
        return showDbPriv;
    }

    /**
     * 
     * @param showDbPriv 
     */
    public void setShowDbPriv(String showDbPriv) {
        this.showDbPriv = showDbPriv == null ? null : showDbPriv.trim();
    }

    /**
     * 
     * @return Super_priv 
     */
    public String getSuperPriv() {
        return superPriv;
    }

    /**
     * 
     * @param superPriv 
     */
    public void setSuperPriv(String superPriv) {
        this.superPriv = superPriv == null ? null : superPriv.trim();
    }

    /**
     * 
     * @return Create_tmp_table_priv 
     */
    public String getCreateTmpTablePriv() {
        return createTmpTablePriv;
    }

    /**
     * 
     * @param createTmpTablePriv 
     */
    public void setCreateTmpTablePriv(String createTmpTablePriv) {
        this.createTmpTablePriv = createTmpTablePriv == null ? null : createTmpTablePriv.trim();
    }

    /**
     * 
     * @return Lock_tables_priv 
     */
    public String getLockTablesPriv() {
        return lockTablesPriv;
    }

    /**
     * 
     * @param lockTablesPriv 
     */
    public void setLockTablesPriv(String lockTablesPriv) {
        this.lockTablesPriv = lockTablesPriv == null ? null : lockTablesPriv.trim();
    }

    /**
     * 
     * @return Execute_priv 
     */
    public String getExecutePriv() {
        return executePriv;
    }

    /**
     * 
     * @param executePriv 
     */
    public void setExecutePriv(String executePriv) {
        this.executePriv = executePriv == null ? null : executePriv.trim();
    }

    /**
     * 
     * @return Repl_slave_priv 
     */
    public String getReplSlavePriv() {
        return replSlavePriv;
    }

    /**
     * 
     * @param replSlavePriv 
     */
    public void setReplSlavePriv(String replSlavePriv) {
        this.replSlavePriv = replSlavePriv == null ? null : replSlavePriv.trim();
    }

    /**
     * 
     * @return Repl_client_priv 
     */
    public String getReplClientPriv() {
        return replClientPriv;
    }

    /**
     * 
     * @param replClientPriv 
     */
    public void setReplClientPriv(String replClientPriv) {
        this.replClientPriv = replClientPriv == null ? null : replClientPriv.trim();
    }

    /**
     * 
     * @return Create_view_priv 
     */
    public String getCreateViewPriv() {
        return createViewPriv;
    }

    /**
     * 
     * @param createViewPriv 
     */
    public void setCreateViewPriv(String createViewPriv) {
        this.createViewPriv = createViewPriv == null ? null : createViewPriv.trim();
    }

    /**
     * 
     * @return Show_view_priv 
     */
    public String getShowViewPriv() {
        return showViewPriv;
    }

    /**
     * 
     * @param showViewPriv 
     */
    public void setShowViewPriv(String showViewPriv) {
        this.showViewPriv = showViewPriv == null ? null : showViewPriv.trim();
    }

    /**
     * 
     * @return Create_routine_priv 
     */
    public String getCreateRoutinePriv() {
        return createRoutinePriv;
    }

    /**
     * 
     * @param createRoutinePriv 
     */
    public void setCreateRoutinePriv(String createRoutinePriv) {
        this.createRoutinePriv = createRoutinePriv == null ? null : createRoutinePriv.trim();
    }

    /**
     * 
     * @return Alter_routine_priv 
     */
    public String getAlterRoutinePriv() {
        return alterRoutinePriv;
    }

    /**
     * 
     * @param alterRoutinePriv 
     */
    public void setAlterRoutinePriv(String alterRoutinePriv) {
        this.alterRoutinePriv = alterRoutinePriv == null ? null : alterRoutinePriv.trim();
    }

    /**
     * 
     * @return Create_user_priv 
     */
    public String getCreateUserPriv() {
        return createUserPriv;
    }

    /**
     * 
     * @param createUserPriv 
     */
    public void setCreateUserPriv(String createUserPriv) {
        this.createUserPriv = createUserPriv == null ? null : createUserPriv.trim();
    }

    /**
     * 
     * @return Event_priv 
     */
    public String getEventPriv() {
        return eventPriv;
    }

    /**
     * 
     * @param eventPriv 
     */
    public void setEventPriv(String eventPriv) {
        this.eventPriv = eventPriv == null ? null : eventPriv.trim();
    }

    /**
     * 
     * @return Trigger_priv 
     */
    public String getTriggerPriv() {
        return triggerPriv;
    }

    /**
     * 
     * @param triggerPriv 
     */
    public void setTriggerPriv(String triggerPriv) {
        this.triggerPriv = triggerPriv == null ? null : triggerPriv.trim();
    }

    /**
     * 
     * @return Create_tablespace_priv 
     */
    public String getCreateTablespacePriv() {
        return createTablespacePriv;
    }

    /**
     * 
     * @param createTablespacePriv 
     */
    public void setCreateTablespacePriv(String createTablespacePriv) {
        this.createTablespacePriv = createTablespacePriv == null ? null : createTablespacePriv.trim();
    }

    /**
     * 
     * @return ssl_type 
     */
    public String getSslType() {
        return sslType;
    }

    /**
     * 
     * @param sslType 
     */
    public void setSslType(String sslType) {
        this.sslType = sslType == null ? null : sslType.trim();
    }

    /**
     * 
     * @return max_questions 
     */
    public Integer getMaxQuestions() {
        return maxQuestions;
    }

    /**
     * 
     * @param maxQuestions 
     */
    public void setMaxQuestions(Integer maxQuestions) {
        this.maxQuestions = maxQuestions;
    }

    /**
     * 
     * @return max_updates 
     */
    public Integer getMaxUpdates() {
        return maxUpdates;
    }

    /**
     * 
     * @param maxUpdates 
     */
    public void setMaxUpdates(Integer maxUpdates) {
        this.maxUpdates = maxUpdates;
    }

    /**
     * 
     * @return max_connections 
     */
    public Integer getMaxConnections() {
        return maxConnections;
    }

    /**
     * 
     * @param maxConnections 
     */
    public void setMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
    }

    /**
     * 
     * @return max_user_connections 
     */
    public Integer getMaxUserConnections() {
        return maxUserConnections;
    }

    /**
     * 
     * @param maxUserConnections 
     */
    public void setMaxUserConnections(Integer maxUserConnections) {
        this.maxUserConnections = maxUserConnections;
    }

    /**
     * 
     * @return plugin 
     */
    public String getPlugin() {
        return plugin;
    }

    /**
     * 
     * @param plugin 
     */
    public void setPlugin(String plugin) {
        this.plugin = plugin == null ? null : plugin.trim();
    }

    /**
     * 
     * @return password_expired 
     */
    public String getPasswordExpired() {
        return passwordExpired;
    }

    /**
     * 
     * @param passwordExpired 
     */
    public void setPasswordExpired(String passwordExpired) {
        this.passwordExpired = passwordExpired == null ? null : passwordExpired.trim();
    }

    /**
     * 
     * @return password_last_changed 
     */
    public Date getPasswordLastChanged() {
        return passwordLastChanged;
    }

    /**
     * 
     * @param passwordLastChanged 
     */
    public void setPasswordLastChanged(Date passwordLastChanged) {
        this.passwordLastChanged = passwordLastChanged;
    }

    /**
     * 
     * @return password_lifetime 
     */
    public Short getPasswordLifetime() {
        return passwordLifetime;
    }

    /**
     * 
     * @param passwordLifetime 
     */
    public void setPasswordLifetime(Short passwordLifetime) {
        this.passwordLifetime = passwordLifetime;
    }

    /**
     * 
     * @return account_locked 
     */
    public String getAccountLocked() {
        return accountLocked;
    }

    /**
     * 
     * @param accountLocked 
     */
    public void setAccountLocked(String accountLocked) {
        this.accountLocked = accountLocked == null ? null : accountLocked.trim();
    }
}