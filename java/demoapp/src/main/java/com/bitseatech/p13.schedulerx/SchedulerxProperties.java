package com.bitseatech.p13.schedulerx;

import com.alibaba.schedulerx.worker.domain.WorkerConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * schedulerx worker启动配置
 *
 * @author 陆昆
 **/
@ConfigurationProperties(prefix = "spring.schedulerx2")
public class SchedulerxProperties {
    /**
     * 对应不同环境SchedulerX控制台域名
     * 文档见：https://yuque.antfin-inc.com/schedulerx/igu2vh/hbdgke
     */
    private String domainName;

    /**
     * 分组id：控制台应用管理界面查看
     */
    private String groupId;

    /**
     * 特殊场景多网卡或vpc环境指定客户端ip使用
     * https://yuque.antfin-inc.com/schedulerx/igu2vh/fvrpgq#664063c9
     */
    private String host;

    /**
     * 用户自定义schedulerx-worker的端口
     */
    private int port = 0;

    /**
     * 单元隔离白名单指定触发单元使用：多个单元以逗号分隔，不能带空格
     * 具体参考文档：https://yuque.antfin-inc.com/schedulerx/igu2vh/fvrpgq#664063c9
     */
    private String enableUnits;

    /**
     * 单元隔离黑名单指定不可触发单元：多个单元以逗号分隔，不能带空格，如果设置了白名单，以白名单为准，黑名单失效
     * 具体参考文档：https://yuque.antfin-inc.com/schedulerx/igu2vh/fvrpgq#664063c9
     */
    private String disableUnits;

    /**
     * 机房隔离白名单，多个机房以逗号分隔，不能带空格
     */
    private String enableSites;

    /**
     * 单元隔离黑名单，如果设置了白名单，以白名单为准，黑名单失效
     */
    private String disableSites;

    /**
     * 是否启用网格计算，默认不启用。开启这个开关，客户端启动会增加20秒+时间，
     * 如果没有用到网格计算不建议设置。如果用到了网格计算，建议开启，否则每台机器的第一次触发会延迟20秒+才运行。
     */
    private boolean enableBatchWork;

    /**
     * 默认true启动starter；false则关闭该starter
     */
    private boolean enabled = true;

    /**
     * groupId的appKey
     */
    private String appKey;

    /**
     * 阿里云ak
     */
    private String aliyunAccessKey;
    /**
     * 阿里云sk
     */
    private String aliyunSecretKey;

    /**
     * STS ak
     */
    private String stsAccessKey;

    /**
     * STS sk
     */
    private String stsSecretKey;

    /**
     * STS secret token
     */
    private String stsToken;

    /**
     * 命名空间key
     */
    private String namespace;

    /**
     * 寻址服务地址
     */
    private String endpoint;

    /**
     * 寻址服务端口号
     */
    private String endpointPort;

    /**
     * 命名空间来源
     */
    private String namespaceSource;

    /**
     * 用户自定义taskBody大小，单位byte
     */
    private int maxTaskBodySize = WorkerConstants.TASK_BODY_SIZE_MAX_DEFAULT;

    private boolean blockAppStart = true;

    /**
     * SLS日志收集器开关
     */
    private boolean slsCollectorEnable = true;

    /**
     * 是否开启共享containerPool的开关
     */
    private boolean shareContainerPool = false;

    /**
     * 共享containerPool的自定义线程池大小
     */
    private int sharePoolSize = WorkerConstants.SHARE_POOL_SIZE_DEFAULT;

    /**
     * Work集群内部标签，同标签将会启动一个
     */
    private String label;

    /**
     * 如果使用了非alios的docker环境(包括k8s)，需要开启该开关
     */
    private boolean enableCgroupMetrics = false;

    /**
     * 默认cgroup路径为/sys/fs/cgroup/cpu/，如果不同需要修改，否则无法采集到cgroup数据
     */
    private String cgroupPathPrefix = "/sys/fs/cgroup/cpu/";

    /**
     * akka remoting被隔离了，是否自动恢复
     */
    private boolean akkaRemotingAutoRecover = true;

    /**
     * 是否启用heartbeat日志
     * @return
     */
    private boolean enableHeartbeatLog = true;

    /**
     * Map模型状态检查间隔(ms)
     * @return
     */
    private int mapMasterStatusCheckInterval = WorkerConstants.Map_MASTER_STATUS_CHECK_INTERVAL_DEFAULT;

    /**
     * 启动second_delay间隔单位为ms，默认为秒
     * @return
     */
    private boolean enableSecondDealyCycleIntervalMs = false;

    /**
     * 启用MapMaster failover能力，默认启用
     */
    private boolean enableMapMasterFailover = true;

    /**
     * schedulerx worker请求console接口的http超时时间，默认10秒
     * @return
     */
//    private Long httpConnectionTimeout;

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getEnableUnits() {
        return enableUnits;
    }

    public void setEnableUnits(String enableUnits) {
        this.enableUnits = enableUnits;
    }

    public String getDisableUnits() {
        return disableUnits;
    }

    public void setDisableUnits(String disableUnits) {
        this.disableUnits = disableUnits;
    }

    public String getEnableSites() {
        return enableSites;
    }

    public void setEnableSites(String enableSites) {
        this.enableSites = enableSites;
    }

    public String getDisableSites() {
        return disableSites;
    }

    public void setDisableSites(String disableSites) {
        this.disableSites = disableSites;
    }

    public boolean isEnableBatchWork() {
        return enableBatchWork;
    }

    public void setEnableBatchWork(boolean enableBatchWork) {
        this.enableBatchWork = enableBatchWork;
    }

    public String getAliyunAccessKey() {
        return aliyunAccessKey;
    }

    public void setAliyunAccessKey(String aliyunAccessKey) {
        this.aliyunAccessKey = aliyunAccessKey;
    }

    public String getAliyunSecretKey() {
        return aliyunSecretKey;
    }

    public void setAliyunSecretKey(String aliyunSecretKey) {
        this.aliyunSecretKey = aliyunSecretKey;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpointPort() {
        return endpointPort;
    }

    public void setEndpointPort(String endpointPort) {
        this.endpointPort = endpointPort;
    }

    public String getNamespaceSource() {
        return namespaceSource;
    }

    public void setNamespaceSource(String namespaceSource) {
        this.namespaceSource = namespaceSource;
    }

    public int getMaxTaskBodySize() {
        return maxTaskBodySize;
    }

    public void setMaxTaskBodySize(int maxTaskBodySize) {
        this.maxTaskBodySize = maxTaskBodySize;
    }

    public boolean isBlockAppStart() {
        return blockAppStart;
    }

    public void setBlockAppStart(boolean blockAppStart) {
        this.blockAppStart = blockAppStart;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getStsAccessKey() {
        return stsAccessKey;
    }

    public void setStsAccessKey(String stsAccessKey) {
        this.stsAccessKey = stsAccessKey;
    }

    public String getStsSecretKey() {
        return stsSecretKey;
    }

    public void setStsSecretKey(String stsSecretKey) {
        this.stsSecretKey = stsSecretKey;
    }

    public String getStsToken() {
        return stsToken;
    }

    public void setStsToken(String stsToken) {
        this.stsToken = stsToken;
    }

    public boolean isSlsCollectorEnable() {
        return slsCollectorEnable;
    }

    public void setSlsCollectorEnable(boolean slsCollectorEnable) {
        this.slsCollectorEnable = slsCollectorEnable;
    }

    public boolean isShareContainerPool() {
        return shareContainerPool;
    }

    public void setShareContainerPool(boolean shareContainerPool) {
        this.shareContainerPool = shareContainerPool;
    }

    public int getSharePoolSize() {
        return sharePoolSize;
    }

    public void setSharePoolSize(int sharePoolSize) {
        this.sharePoolSize = sharePoolSize;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isEnableCgroupMetrics() {
        return enableCgroupMetrics;
    }

    public void setEnableCgroupMetrics(boolean enableCgroupMetrics) {
        this.enableCgroupMetrics = enableCgroupMetrics;
    }

    public String getCgroupPathPrefix() {
        return cgroupPathPrefix;
    }

    public void setCgroupPathPrefix(String cgroupPathPrefix) {
        this.cgroupPathPrefix = cgroupPathPrefix;
    }

    public boolean isAkkaRemotingAutoRecover() {
        return akkaRemotingAutoRecover;
    }

    public void setAkkaRemotingAutoRecover(boolean akkaRemotingAutoRecover) {
        this.akkaRemotingAutoRecover = akkaRemotingAutoRecover;
    }

    public boolean isEnableHeartbeatLog() {
        return enableHeartbeatLog;
    }

    public void setEnableHeartbeatLog(boolean enableHeartbeatLog) {
        this.enableHeartbeatLog = enableHeartbeatLog;
    }

    public int getMapMasterStatusCheckInterval() {
        return mapMasterStatusCheckInterval;
    }

    public void setMapMasterStatusCheckInterval(int mapMasterStatusCheckInterval) {
        this.mapMasterStatusCheckInterval = mapMasterStatusCheckInterval;
    }

    public boolean isEnableSecondDealyCycleIntervalMs() {
        return enableSecondDealyCycleIntervalMs;
    }

    public void setEnableSecondDealyCycleIntervalMs(boolean enableSecondDealyCycleIntervalMs) {
        this.enableSecondDealyCycleIntervalMs = enableSecondDealyCycleIntervalMs;
    }

    public boolean isEnableMapMasterFailover() {
        return enableMapMasterFailover;
    }

    public void setEnableMapMasterFailover(boolean enableMapMasterFailover) {
        this.enableMapMasterFailover = enableMapMasterFailover;
    }

}
