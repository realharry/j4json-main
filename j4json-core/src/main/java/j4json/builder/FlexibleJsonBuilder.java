package j4json.builder;

import j4json.builder.policy.BuilderPolicy;


/**
 * JsonBuilder with configurable options.
 */
public interface FlexibleJsonBuilder extends JsonBuilder
{
    /**
     * Get the BuilderPolicy object associated with this JsonBuilder object.
     */
    BuilderPolicy getBuilderPolicy();
}
