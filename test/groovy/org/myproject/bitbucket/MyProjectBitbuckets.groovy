package org.myproject.bitbucket

import com.github.d1le.pipeline.bitbucket.Bitbucket
import com.github.d1le.pipeline.bitbucket.Bitbuckets

/**
 * @author Alexey Lapin
 */
class MyProjectBitbuckets extends Bitbuckets {

    public static final String HOST_MYCO_BITBUCKET_CI = "bitbucket-ci.myco.org"
    public static final String HOST_MYCO_BITBUCKET_PROD = "bitbucket-prod.myco.org"

    Bitbucket ci() {
        get(HOST_MYCO_BITBUCKET_CI)
    }

    Bitbucket prod() {
        get(HOST_MYCO_BITBUCKET_PROD)
    }
}
