/*
 * Created on Feb 28, 2005
 */
package dguitar.adaptors.song.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import dguitar.adaptors.song.SongEvent;
import dguitar.adaptors.song.SongMeasureTrack;
import dguitar.adaptors.song.SongTrack;
import dguitar.adaptors.song.SongVirtualTrack;


/**
 * Implementation of SongMeasureTrack
 * @author crnash
 */
public class SongMeasureTrackImpl implements SongMeasureTrack
{
    SongTrack track;
    Vector virtualTracks;

    public SongMeasureTrackImpl(SongTrack track)
    {
        this.track=track;
        
        int virtualTrackCount=track.getVirtualTrackCount();
        virtualTracks=new Vector(virtualTrackCount);
        
        for(int i=0;i<virtualTrackCount;i++)
        {
            virtualTracks.add(new SongVirtualTrackImpl(this,i));
        }
    }
    /* (non-Javadoc)
     * @see adaptors.song.SongMeasureTrack#getVirtualTrack(int)
     */
    public SongVirtualTrack getVirtualTrack(int virtualTrackID)
    {
        return (SongVirtualTrack)virtualTracks.get(virtualTrackID);
    }

    /* (non-Javadoc)
     * @see adaptors.song.SongMeasureTrack#getEvents()
     */
    public List getEvents()
    {
        List x=new Vector();
        for(int i=0;i<virtualTracks.size();i++)
        {
            SongVirtualTrack svt=(SongVirtualTrack) virtualTracks.get(i);
            x.addAll(svt.getEvents());
        }
        // the concatenated list of events are not necessarily sorted...
        
        Collections.sort(x,new Comparator(){

            public int compare(Object o1, Object o2)
            {
                SongEvent s1=(SongEvent)o1;
                SongEvent s2=(SongEvent)o2;
                return s1.getTime()-s2.getTime();
            }
        });
        
        return x;
    }
    
    /* (non-Javadoc)
     * @see adaptors.song.SongMeasureTrack#getTrack()
     */
    public SongTrack getTrack()
    {
        return track;
    }
}
