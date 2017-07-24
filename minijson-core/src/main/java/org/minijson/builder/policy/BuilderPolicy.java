package org.minijson.builder.policy;


/**
 * A "strategy" for JSON building options.
 * Note that this option should be consistently used within a module or even within an app.
 * This option determines how an object is serialized to json.
 * If you use different policies from type to type (or, even object to object),
 *     your app's serialization behavior might appear rather inconsistent.
 */
public interface BuilderPolicy
{
    // Note that this is not exactly a strategy/policy a la "strategy pattern", at this point.
    // May need some re-factoring...

    /**
     * Depth below a bean/map/list behavior.
     * it applies to a bean/map/list's children of types {map, list, bean}.
     * depth==1 means use introspection down to this object (attr->value) only, or, top-level map/list only, etc.
     * if useBeanIntrospection() == false, we only drill down for map and list.
     * Special value: -1 means no limit in drilling down.
     *    (note that the drill down might end up infinite, e.g., due to cyclic object dependencies, etc.
     *       --> therefore, the implementation should put a hard limit.)
     */
    int drillDownDepth();

    /**
     * Whether to read bean attrs (getXXX()).
     */
    boolean useBeanIntrospection();

    /**
     * Forward slash need not generally be escaped (except for "</").
     * If 1 (== true), then all /'s will be escaped.
     * if 0 (== false), then slahes will not be escaped (except for "</").
     * If -1, then no slash (including the one in "</") will be escaped.
     * This should be 0 by default.
     */
    int escapeForwardSlash();

    // TBD:
    // Whether to use JDK "built-in" class -> "Standard" Json mapping???
    // ...
    
    // TBD:
    // Put "indent" options here?
    //    rather than putting it in JsonSerializable interface ??? 
    // .....
    
}
