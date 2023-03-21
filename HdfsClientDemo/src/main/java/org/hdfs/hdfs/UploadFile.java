package org.hdfs.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class UploadFile {

    @Test
    public void testCopyFromLocalFile() throws IOException,
            InterruptedException, URISyntaxException{

        //1.获取文件系统
        Configuration configuration = new Configuration();
        //测试参数优先级
//        configuration.set("dfs.replication","2");
        //优先级顺序,从高到低
        /*1.客户端代码中设置的值（这里的值）
        * 2.ClassPath下的用户自定义配置文件（hdfs-site.xml）
        * 3.服务器的自定义配置（服务器端hdfs-site.xml）
        * 4.服务器的默认配置（xxx-default.xml）*/
        FileSystem fs= FileSystem.get(new URI("hdfs://hadoop102:8020"),
                configuration,"hadoop");

        //2.文件上传
        fs.copyFromLocalFile(new Path("E:/workspace/tmp/123.txt"),
                new Path("/xiyou/huaguoshan"));

        //3.关闭资源
        fs.close();
    }
}
