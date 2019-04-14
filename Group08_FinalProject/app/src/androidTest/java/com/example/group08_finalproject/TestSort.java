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


public class TestSort {

    @Test
    public void testSortCollisions() throws IOException {
        Collision[] collisions = Read.read();

        SortCollisions.sort(collisions, collisions.length);

        assert(collisions[0].toString().equals("X-coord: -122.327644 Y-coord: 47.630596 com.example.group08_finalproject.Collision Description: \"MOTOR VEHICLE STRUCK PEDALCYCLIST com.example.group08_finalproject.Collision Type:  Junction Type: At com.example.group08_finalproject.Intersection (intersection related) Light Condition:  Severe Injuries: 0 Severity Code:  Fatalities: 0 Injuries: 0"));
        assert(collisions[1].toString().equals("X-coord: -122.28652 Y-coord: 47.587086 com.example.group08_finalproject.Collision Description: \"MOTOR VEHICLE STRUCK MOTOR VEHICLE com.example.group08_finalproject.Collision Type:  Junction Type: Mid-Block (not related to intersection) Light Condition:  Severe Injuries: 0 Severity Code: 0 Fatalities: 0 Injuries: 0"));
        assert(collisions[2].toString().equals("X-coord: -122.38055 Y-coord: 47.69398 com.example.group08_finalproject.Collision Description: \"MOTOR VEHICLE STRUCK MOTOR VEHICLE com.example.group08_finalproject.Collision Type:  Junction Type: Mid-Block (not related to intersection) Light Condition:  Severe Injuries: 0 Severity Code: 0 Fatalities: 0 Injuries: 0"));
        assert(collisions[3].toString().equals("X-coord: -122.33512 Y-coord: 47.587166 com.example.group08_finalproject.Collision Description: \"MOTOR VEHICLE STRUCK MOTOR VEHICLE com.example.group08_finalproject.Collision Type:  Junction Type: Mid-Block (not related to intersection) Light Condition:  Severe Injuries: 0 Severity Code: 0 Fatalities: 0 Injuries: 0"));

        assert(collisions[collisions.length-6].toString().equals("X-coord: -122.32313 Y-coord: 47.520477 com.example.group08_finalproject.Collision Description: MOTOR VEHICLE RAN OFF ROAD - HIT FIXED OBJECT com.example.group08_finalproject.Collision Type: Other Junction Type: Mid-Block (not related to intersection) Light Condition:  Severe Injuries: 1 Severity Code: 3 Fatalities: 2 Injuries: 4"));
        assert(collisions[collisions.length-5].toString().equals("X-coord: -122.29264 Y-coord: 47.68305 com.example.group08_finalproject.Collision Description: MOTOR VEHCILE STRUCK PEDESTRIAN com.example.group08_finalproject.Collision Type: Pedestrian Junction Type: At com.example.group08_finalproject.Intersection (intersection related) Light Condition:  Severe Injuries: 2 Severity Code: 3 Fatalities: 2 Injuries: 2"));
        assert(collisions[collisions.length-4].toString().equals("X-coord: -122.341995 Y-coord: 47.57143 com.example.group08_finalproject.Collision Description: MOTOR VEHICLE STRUCK OBJECT IN ROAD com.example.group08_finalproject.Collision Type: Other Junction Type: Mid-Block (not related to intersection) Light Condition:  Severe Injuries: 0 Severity Code: 3 Fatalities: 3 Injuries: 0"));
        assert(collisions[collisions.length-3].toString().equals("X-coord: -122.39537 Y-coord: 47.66827 com.example.group08_finalproject.Collision Description: MOTOR VEHICLE RAN OFF ROAD - HIT FIXED OBJECT com.example.group08_finalproject.Collision Type: Other Junction Type: Mid-Block (but intersection related) Light Condition:  Severe Injuries: 1 Severity Code: 3 Fatalities: 3 Injuries: 1"));
        assert(collisions[collisions.length-2].toString().equals("X-coord: -122.26115 Y-coord: 47.520317 com.example.group08_finalproject.Collision Description: MOTOR VEHICLE RAN OFF ROAD - HIT FIXED OBJECT com.example.group08_finalproject.Collision Type: Other Junction Type: Mid-Block (not related to intersection) Light Condition:  Severe Injuries: 0 Severity Code: 3 Fatalities: 4 Injuries: 0"));
        assert(collisions[collisions.length-1].toString().equals("X-coord: -122.3473 Y-coord: 47.64717 com.example.group08_finalproject.Collision Description: MOTOR VEHICLE STRUCK OBJECT IN ROAD com.example.group08_finalproject.Collision Type: Head On Junction Type: Mid-Block (not related to intersection) Light Condition:  Severe Injuries: 41 Severity Code: 3 Fatalities: 5 Injuries: 78"));

        //sorting an empty array
        Collision[] empty = {};
        SortCollisions.sort(empty, empty.length);
        assert(empty.length == 0);
    }

    @Test
    public void testSortIntersections() throws IOException {
        Intersection[] intersections = ReadIntersections.read();

        SortIntersectionDropDown.sort(intersections, intersections.length);

        assert(intersections[intersections.length-6].toString().equals("StreetNS: YALE AVE N StreetEW: DEAD END 2"));
        assert(intersections[intersections.length-1].toString().equals("StreetNS: YUKON AVE S StreetEW: S HENDERSON ST"));

        //sorting an empty array
        Intersection[] empty = {};
        SortIntersectionDropDown.sort(empty, empty.length);
        assert(empty.length == 0);
    }
}
