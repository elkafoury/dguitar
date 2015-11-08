/*
 * Created on Mar 16, 2005
 */
package dguitar.adaptors.song.impl;

import java.util.LinkedList;
import java.util.List;

import dguitar.adaptors.song.SongEvent;
import dguitar.adaptors.song.SongMeasureTrack;
import dguitar.adaptors.song.SongVirtualTrack;


/**
 * @author Chris
 */
public class SongVirtualTrackImpl implements SongVirtualTrack
{
    SongMeasureTrack track;
    int index;
    List events = new LinkedList();

    /**
     * @param track
     * @param index
     */
    public SongVirtualTrackImpl(SongMeasureTrack track, int index)
    {
        this.track = track;
        this.index = index;
    }
    /**
     * @return Returns the index.
     */
    public int getIndex()
    {
        return index;
    }
    /**
     * @return Returns the track.
     */
    public SongMeasureTrack getMeasureTrack()
    {
        return track;
    }
    public void addEvents(List subEvents)
    {
        events.addAll(subEvents);
    }
    public List getEvents()
    {
        return events;
    }
    public void addEvent(SongEvent event)
    {
        event.setVirtualTrack(this);
        events.add(event);        
    }
}
