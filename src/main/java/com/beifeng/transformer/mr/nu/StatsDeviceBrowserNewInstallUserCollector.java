package com.beifeng.transformer.mr.nu;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;

import com.beifeng.common.GlobalConstants;
import com.beifeng.transformer.model.dim.StatsUserDimension;
import com.beifeng.transformer.model.dim.base.BaseDimension;
import com.beifeng.transformer.model.value.BaseStatsValueWritable;
import com.beifeng.transformer.model.value.reduce.MapWritableValue;
import com.beifeng.transformer.mr.IOutputCollector;
import com.beifeng.transformer.service.rpc.IDimensionConverter;
/**
 * 
 * @Description:数据处理
 * @author wangxueqiang
 * @date 2018年11月1日 上午9:09:30
 *
 */
public class StatsDeviceBrowserNewInstallUserCollector implements IOutputCollector {
    @Override
    public void collect(Configuration conf, BaseDimension key, BaseStatsValueWritable value, PreparedStatement pstmt, IDimensionConverter converter) throws SQLException, IOException {
        StatsUserDimension statsUserDimension = (StatsUserDimension) key;
        MapWritableValue mapWritableValue = (MapWritableValue) value;
        IntWritable newInstallUsers = (IntWritable) mapWritableValue.getValue().get(new IntWritable(-1));

        int i = 0;
        pstmt.setInt(++i, converter.getDimensionIdByValue(statsUserDimension.getStatsCommon().getPlatform()));
        pstmt.setInt(++i, converter.getDimensionIdByValue(statsUserDimension.getStatsCommon().getDate()));
        pstmt.setInt(++i, converter.getDimensionIdByValue(statsUserDimension.getBrowser()));
        pstmt.setInt(++i, newInstallUsers.get());
        pstmt.setString(++i, conf.get(GlobalConstants.RUNNING_DATE_PARAMES));
        pstmt.setInt(++i, newInstallUsers.get());
        pstmt.addBatch();
    }

}
