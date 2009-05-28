/*
 * Copyright 2009 Alin Dreghiciu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.runner.platform.internal;

import java.io.File;
import java.net.URL;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ops4j.pax.runner.platform.FilePathStrategy;

/**
 * A {@link org.ops4j.pax.runner.platform.FilePathStrategy} that normalizes the paths to absolute file paths.
 *
 * @author Alin Dreghiciu (adreghiciu@gmail.com)
 * @since 0.20.0, may 10, 2009
 */
public class AbsoluteFilePathStrategy
    implements FilePathStrategy
{

    /**
     * JCL
     */
    private static Log LOG = LogFactory.getLog( AbsoluteFilePathStrategy.class );

    /**
     * {@inheritDoc}
     */
    public String normalizeAsPath( final File file )
    {
        return normalizePath( file );
    }

    /**
     * {@inheritDoc}
     */
    public String normalizeAsUrl( final File file )
    {
        return "file:" + normalizePath( file );
    }

    /**
     * {@inheritDoc}
     */
    public String normalizeAsUrl( final URL url )
    {
        if( "file".equals( url.getProtocol() ) )
        {
            return "file:" + normalizePath( new File( url.getFile() ) );
        }
        return url.toExternalForm();
    }

    /**
     * Normalizes the path by returning the absolute paths of teh file.
     *
     * @param file to be normalized.
     *
     * @return absolute path to the file
     */
    private String normalizePath( final File file )
    {
        return file.getAbsolutePath();
    }

}