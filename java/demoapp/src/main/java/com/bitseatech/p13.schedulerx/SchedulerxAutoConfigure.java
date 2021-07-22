package com.bitseatech.p13.schedulerx;

import com.alibaba.schedulerx.common.util.ConfigUtil;
import com.alibaba.schedulerx.worker.SchedulerxWorker;
import com.alibaba.schedulerx.worker.domain.WorkerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * schedulerx2配置启动
 *
 * @author 陆昆
 **/
@Configuration
@DependsOn("processContainer")
public class SchedulerxAutoConfigure {
    @Autowired
    private SchedulerxProperties properties;

    @Bean
    public SchedulerxWorker schedulerxWorker() {
        SchedulerxWorker schedulerxWorker = new SchedulerxWorker();
        schedulerxWorker.setDomainName(properties.getDomainName());
        schedulerxWorker.setGroupId(properties.getGroupId());
        schedulerxWorker.setEnableBatchWork(properties.isEnableBatchWork());
        schedulerxWorker.setDisableSites(properties.getDisableSites());
        schedulerxWorker.setEnableSites(properties.getEnableSites());
        schedulerxWorker.setDisableUnits(properties.getDisableUnits());
        schedulerxWorker.setEnableUnits(properties.getEnableUnits());
        schedulerxWorker.setAppKey(properties.getAppKey());
        schedulerxWorker.setAliyunAccessKey(properties.getAliyunAccessKey());
        schedulerxWorker.setAliyunSecretKey(properties.getAliyunSecretKey());
        schedulerxWorker.setNamespace(properties.getNamespace());
        schedulerxWorker.setHost(properties.getHost());
        schedulerxWorker.setPort(properties.getPort());
        schedulerxWorker.setEndpoint(properties.getEndpoint());
        schedulerxWorker.setNamespaceSource(properties.getNamespaceSource());
        schedulerxWorker.setMaxTaskBodySize(properties.getMaxTaskBodySize());
        schedulerxWorker.setBlockAppStart(properties.isBlockAppStart());
        schedulerxWorker.setSTSAccessKey(properties.getStsAccessKey());
        schedulerxWorker.setSTSSecretKey(properties.getStsSecretKey());
        schedulerxWorker.setSTSSecretToken(properties.getStsToken());
        schedulerxWorker.setSlsCollectorEnable(properties.isSlsCollectorEnable());
        schedulerxWorker.setShareContainerPool(properties.isShareContainerPool());
        schedulerxWorker.setLabel(properties.getLabel());
        if (properties.isShareContainerPool()) {
            schedulerxWorker.setSharePoolSize(properties.getSharePoolSize());
        }
        if (properties.getEndpointPort() != null && !properties.getEndpointPort().isEmpty()) {
            schedulerxWorker.setEndpointPort(Integer.parseInt(properties.getEndpointPort()));
        }
        schedulerxWorker.setEnableCgroupMetrics(properties.isEnableCgroupMetrics());
        if (properties.isEnableCgroupMetrics()) {
            schedulerxWorker.setCgroupPathPrefix(properties.getCgroupPathPrefix());
        }
        schedulerxWorker.setAkkaRemotingAutoRecover(properties.isAkkaRemotingAutoRecover());
        schedulerxWorker.setEnableHeartbeatLog(properties.isEnableHeartbeatLog());
        schedulerxWorker.setMapMasterStatusCheckInterval(properties.getMapMasterStatusCheckInterval());
        schedulerxWorker.setEnableSecondDelayCycleIntervalMs(properties.isEnableSecondDealyCycleIntervalMs());
        schedulerxWorker.setEnableMapMasterFailover(properties.isEnableMapMasterFailover());

        // 设置启动模式
        ConfigUtil.getWorkerConfig().setProperty(WorkerConstants.WORKER_STARTER_MODE,
            WorkerConstants.WORKER_STARTER_SPRINGBOOT);
        return schedulerxWorker;
    }
}
