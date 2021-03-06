package j4json.builder.impl;

import java.util.logging.Logger;
import j4json.builder.BareJsonBuilder;
import j4json.builder.policy.BuilderPolicy;


/**
 * Simple BareJsonBuilder implementation.
 */
public final class SimpleJsonBuilder extends AbstractBareJsonBuilder implements BareJsonBuilder
{
    private static final Logger log = Logger.getLogger(SimpleJsonBuilder.class.getName());

    public SimpleJsonBuilder()
    {
        super();
    }
    public SimpleJsonBuilder(BuilderPolicy builderPolicy)
    {
        super(builderPolicy);
    }
    public SimpleJsonBuilder(BuilderPolicy builderPolicy, boolean threadSafe)
    {
        super(builderPolicy, threadSafe);
    }



}
