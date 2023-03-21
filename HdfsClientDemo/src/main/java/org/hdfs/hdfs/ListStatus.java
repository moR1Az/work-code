package org.hdfs.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ListStatus {

    @Test
    public void testListStatus() throws URISyntaxException, IOException, InterruptedException {
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop102:8020"), configuration,
                "hadoop");

        FileStatus[] listStatus = fs.listStatus(new Path("/"));

        //遍历目录
        for (FileStatus fileStatus:listStatus){

            //如果是文件
            if (fileStatus.isFile()){
                System.out.println("f:"+fileStatus.getPath().getName());
            }else {
                System.out.println("d:"+fileStatus.getPath().getName());
            }
        }
        fs.close();
    }
}
