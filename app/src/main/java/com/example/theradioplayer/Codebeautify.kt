package com.example.theradioplayer

class Codebeautify {
    var playlist: Playlist? = null

}

class Playlist {
    //var previoussong: SongNowAdaptor.Previoussong? = null
    var song: Song? = null
    //var nextsong: SongNowAdaptor.Nextsong? = null
    //var channel: SongNowAdaptor.Channel? = null
}
/*
    data class Song {
    var title: String? = null
    var description: String? = null
    var artist: String? = null
    var composer: String? = null
    var albumname: String? = null
    var recordlabel: String? = null
    var lyricist: String? = null
    var starttimeutc: String? = null
    var stoptimeutc: String? = null

}

 */

data class Song (
    var title: String = "",
    var description: String = "",
    var artist: String = "",
    var composer: String = "",
    var albumname: String = "",
    var recordlabel: String = "",
    var lyricist: String = "",
    var starttimeutc: String = "",
    var stoptimeutc: String = ""

)