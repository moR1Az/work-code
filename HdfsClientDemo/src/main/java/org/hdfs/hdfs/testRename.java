package org.hdfs.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class testRename {

    @Test
    public void testRename() throws IOException,InterruptedException,
            URISyntaxException{

        //1.获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop102:8020"),configuration
        ,"hadoop");

        //2.Rename
        //更改文件路径为移动，更改移动后文件名为重命名
        fs.rename(new Path("/moria1/moria.txt"),
                new Path("/xiyou/huaguoshan/meihouwang.txt"));

        //3.close FileSystem
        fs.close();
    }
}
