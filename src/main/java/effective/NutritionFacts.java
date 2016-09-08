package effective;

import java.util.ArrayList;

/**
 * A demo of Builder Pattern
 * BP is a good choice when designing classes whose constructors or static factories would have more than a handful of parameters.
 * Created by fred on 8/11/16.
 */
public class NutritionFacts {
//    private final int servingSize;
//    private final int servings;
//    private final int calories;
//    private final int fat;
//    private final int sodium;

    public static class Builder {
//        //Required parameters
//        private final int servingSize;
//        private final int servings;
       ArrayList<Foo> list = new Gson().fromJson("[{x:1}]", ArrayList<Foo>.class);
    }
}


class Foo {

}
