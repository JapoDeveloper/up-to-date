package co.japo.uptodate.repository;

import java.util.ArrayList;
import java.util.List;

import co.japo.uptodate.entity.Feed;
/**
 * Created by japodeveloper on 10/14/17.
 */

public class FeedRepository {

    public static List<Feed> feeds;

    static{
        feeds = new ArrayList(){
            {
                add(new Feed("Coding Horror","http://feeds.feedburner.com/codinghorror?format=xml"));
                add(new Feed("Newest questions tagged android-app","https://meta.stackexchange.com/feeds/tag?tagnames=android-app&sort=newest"));
                add(new Feed("ABC International","http://www.abc.es/rss/feeds/abc_Internacional.xml"));
            }
        };
    }

}
