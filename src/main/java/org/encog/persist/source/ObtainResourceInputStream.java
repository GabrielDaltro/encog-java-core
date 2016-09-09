package org.encog.persist.source;

import org.encog.EncogError;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Obtain an InputStream from an embedded resource.
 */
public class ObtainResourceInputStream implements ObtainInputStream {

    /**
     * The name of the embedded resource.
     */
    private String resourceName;

    /**
     * Construct the source for the specified resource name.
     * @param theResourceName The resource name to read from.
     */
    public ObtainResourceInputStream(String theResourceName) {
        this.resourceName = theResourceName;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public InputStream obtain() {
        final InputStream istream = this.getClass().getResourceAsStream("/"+resourceName);
        if (istream == null) {
            throw new EncogError("Cannot access data set, make sure the resources are available.");
        }
        return istream;
    }
}