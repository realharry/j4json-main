package org.minijson.parser.policy;


/**
 * A "strategy" for parsing options.
 * Currently, it's only minimally used in the default parser implementations. 
 *    (That is, most flag values are false, by default.)
 */
public interface ParserPolicy
{
    // Note that this is not exactly a strategy/policy a la "strategy pattern", at this point.
    // May need some re-factoring...

    /**
     * "Master" flag.
     * If true, all other options are ignored.
     * 
     * @return whether the parsing should be "strict" or "lenient".
     */
    boolean isStrirct();

    ///////////////////////////////////////////////////////
    // The following leniency options apply only when isStrict() == false.
    // (Note: it's possible that even if strict==false,
    //    all following options are false as well, making it effectively strict==true.)
    
    /**
     * If true, JSON string which is not object or array can still be parsed.
     * 
     * @return true if we allow non object/array top-level node.
     */
    boolean allowNonObjectOrNonArray();

    /**
     * If true, we allow the special character sequence "???" (TBD) before the first "{" or "[".
     * (I thought I saw something about this special marker to avoid json array exploitation from GET.
     *     But, I cannot remember what that was....
     *     For now, we use this flag to allow *any* arbitrary chars before "{" or "[".)    
     * 
     * @return true if we allow special marker sequence.
     */
    boolean allowLeadingJsonMarker();

    /**
     * If true, we allow a trailing comma at the end of object/array.
     * Note that we do NOT allow a leading comma.
     * 
     * @return true, if we allow an extra comma after the last element/member of object/array.
     */
    boolean allowTrailingComma();

    /**
     * If true, we allow repeated commas in object/array (e.g., "[a, ,b]")
     * Note: we have two choices when that happens. 
     *   (1) [a,,b] can be interpreted as [a,null,b], or
     *   (2) [a,,b] can be interpreted as [a,b]. 
     * We adopt the second approach.
     * Note that if allowExtraCommas==true, then allowTrailingComma should be true as well.
     * But, not the other way around.
     * (Again, we do not allow a leading commas(s) regardless of this flag.)
     * 
     * @return true if we interpret repeated/consecutive commas as a single comma.
     */
    boolean allowExtraCommas();

    // boolean allowTrailingCommaInObject();
    // boolean allowExtraCommasInObject();
    // boolean allowTrailingCommaInArray();
    // boolean allowExtraCommasInArray();
    
    /**
     * If set to true, then
     * when value in "key:value" is missing, it is treated as null.
     * (Currently, not being used.)
     * 
     * @return true if we allow a missing value in an object member.
     */
    boolean allowEmptyObjectMemberValue();

    /**
     * If true, then literals are case-folded.
     * That is, null, Null, TRUE, etc. are all allowed.
     * 
     * @return true if we ignore the case in literals, "null", "true", and "false".
     */
    boolean caseInsensitiveLiterals();

    
    // TBD:
    // Whether to allow "NaN" and "Infinity" as valid numbers.
    // ...
    
    // TBD:
    // Whether to skip unrecognized/Invalid tokens...
    // ...
    
}
