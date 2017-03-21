package com.jzli.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository 配置初始化
 *
 * @auther yu.ruibo
 * @date 2017/3/7
 */
@Configuration
public class ElasticsearchConfig {

    @Value("${es.clusterName}")
    private String clusterName;
    @Value("#{'${es.host}'.split(',')}")
    private List<String> hosts;
    @Value("${es.port}")
    private Integer port;


    @Bean(name = "elasticsearchTemplate")
    public ElasticsearchTemplate elasticsearchTemplate() {
        Settings.Builder builder = Settings.builder();
        builder = builder.put("cluster.name", clusterName).put("client.transport.sniff", true);
        TransportClient client = null;
        try {
            List<InetSocketTransportAddress> inetSocketTransportAddresses = getAllAddress();
            client = TransportClient.builder().settings(builder).build().addTransportAddresses(inetSocketTransportAddresses.toArray(new InetSocketTransportAddress[inetSocketTransportAddresses.size()]));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        ElasticsearchTemplate template = new ElasticsearchTemplate(client);
        return template;
    }

    public List<InetSocketTransportAddress> getAllAddress() throws UnknownHostException {
        List<InetSocketTransportAddress> addressList = new ArrayList<InetSocketTransportAddress>();
        for (String host : hosts) {
            addressList.add(new InetSocketTransportAddress(InetAddress.getByName(host), port));
        }
        return addressList;
    }
}
