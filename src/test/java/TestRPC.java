import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

import com.beifeng.transformer.model.dim.base.CurrencyTypeDimension;
import com.beifeng.transformer.model.dim.base.PaymentTypeDimension;
import com.beifeng.transformer.service.rpc.IDimensionConverter;
import com.beifeng.transformer.service.rpc.client.DimensionConverterClient;
import com.beifeng.transformer.service.rpc.server.DimensionConverterServer;

public class TestRPC {
    public static void main(String[] args) throws IOException {
        DimensionConverterServer.main(args);
        IDimensionConverter converter = DimensionConverterClient.createDimensionConverter(new Configuration());
        System.out.println(converter);
        System.out.println(converter.getDimensionIdByValue(new CurrencyTypeDimension("测试ctd")));
        System.out.println(converter.getDimensionIdByValue(new PaymentTypeDimension("测试ptd")));
        DimensionConverterClient.stopDimensionConverterProxy(converter);
   
    
    }
}