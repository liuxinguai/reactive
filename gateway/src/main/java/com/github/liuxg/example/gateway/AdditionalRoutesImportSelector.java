package com.github.liuxg.example.gateway;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ClassUtils;

/**
 * @author xinguai.liu
 */
public class AdditionalRoutesImportSelector  implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        if (ClassUtils.isPresent("org.springframework.cloud.gateway.sample.AdditionalRoutes", null)) {
            return new String[] { "org.springframework.cloud.gateway.sample.AdditionalRoutes" };
        }
        return new String[0];
    }

}
