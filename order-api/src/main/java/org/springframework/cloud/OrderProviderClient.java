package org.springframework.cloud;

import org.springframework.cloud.anno.DuckClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dxn
 * date 2020/12/15
 */

@DuckClient(name = "eureka-provider")
public interface OrderProviderClient {
    @GetMapping("/config/name")
    String getConfigName();
}
