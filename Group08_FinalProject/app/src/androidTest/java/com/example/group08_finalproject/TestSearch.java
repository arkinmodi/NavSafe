package com.example.group08_finalproject;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)

public class TestSearch {

    @Test
    public void testSearchIntersection() throws IOException {
        Integer[] intersectionLengths = SearchIntersections.search("1ST AVE", "SENECA ST", "UNIVERSITY ST");
        assert(intersectionLengths[0] == 237);
        assert(intersectionLengths[1] == 2815);

        intersectionLengths = SearchIntersections.search("15TH AVE SW", "SW HOLLY ST", "DEAD END 3");
        assert(intersectionLengths[0] == 3724);
        assert(intersectionLengths[1] == 4968);

        intersectionLengths = SearchIntersections.search("28TH AVE NE", "NE 72ND S ST", "NE 72ND N ST");
        assert(intersectionLengths[0] == 8576);
        assert(intersectionLengths[1] == 2596);

        //street doesn't exist
        intersectionLengths = SearchIntersections.search("25TH AVE NE", "NE 72ND S ST", "NE 72ND S ST");
        assert(intersectionLengths[0] == 15429);
        assert(intersectionLengths[1] == 15429);
    }

    @Test
    public void testSearchCollision() throws IOException {
        Intersection[] intersections = ReadIntersections.read();
        assert(intersections[1028].toString().equals("StreetNS: AIRPORT WAY S StreetEW: S HILL ST"));
        assert(intersections[3654].toString().equals("StreetNS: AIRPORT WAY S StreetEW: S WALKER N ST"));
        assert(intersections[1028].getNS().equals("AIRPORT WAY S"));
        assert(intersections[1028].getEW().equals("S HILL ST"));
        int weight = SearchCollision.search(intersections[1029],intersections[3655]);
        assert(weight == 122);
    }
}
