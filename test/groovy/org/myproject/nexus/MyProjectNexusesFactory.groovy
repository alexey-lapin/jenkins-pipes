package org.myproject.nexus

import org.myproject.jenkins.MyProjectBuildContext
import com.github.d1le.pipeline.cache.CacheEntryProvider
import com.github.d1le.pipeline.nexus.Nexus
import com.github.d1le.pipeline.nexus.NexusImpl

/**
 * @author Alexey Lapin
 */
class MyProjectNexusesFactory implements CacheEntryProvider<String, Nexus> {

    public static final String NEXUS_DEFAULT_REPO_CI = "myco_release"
    public static final String NEXUS_DEFAULT_REPO_PROD = "myco_release"

    @Override
    Nexus get(String key) {
        byUrl(key)
    }

    static Nexus byUrl(String url) {
        switch (url) {
            case MyProjectNexuses.NEXUS_URL_CI:
                return new NexusImpl()
                    .url(url)
                    .credential(MyProjectBuildContext.ctx().jenkins().credentials().nexusCi())
                    .defaultRepo(NEXUS_DEFAULT_REPO_CI)
            case MyProjectNexuses.NEXUS_URL_PROD:
                return new NexusImpl()
                    .url(url)
                    .credential(MyProjectBuildContext.ctx().jenkins().credentials().nexusProd())
                    .defaultRepo(NEXUS_DEFAULT_REPO_PROD)
            default: null
        }
    }
}