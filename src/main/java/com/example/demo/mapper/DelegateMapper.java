package com.example.demo.mapper;

import com.baidu.fsg.uid.worker.entity.WorkerNodeEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DelegateMapper {
    @Select("SELECT ID," +
            "HOST_NAME," +
            "PORT," +
            "TYPE," +
            "LAUNCH_DATE," +
            "MODIFIED," +
            "CREATED" +
            "FROM" +
            "WORKER_NODE" +
            "WHERE" +
            "HOST_NAME = #{host} AND PORT = #{port}")
    WorkerNodeEntity getWorkerNodeByHostPort(@Param("host") String host, @Param("port") String port);

    @Insert("INSERT INTO WORKER_NODE" +
            "(HOST_NAME," +
            "PORT," +
            "TYPE," +
            "LAUNCH_DATE," +
            "MODIFIED," +
            "CREATED)" +
            "VALUES (" +
            "#{hostName}," +
            "#{port}," +
            "#{type}," +
            "#{launchDate}," +
            "NOW()," +
            "NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void addWorkerNode(WorkerNodeEntity workerNodeEntity);
}
