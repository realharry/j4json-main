package j4json.tool.testset;

import java.util.List;


public interface Generator
{
    List<String> generateTestSet(JsonTestSetSpec jsonTestSetSpec);

}
