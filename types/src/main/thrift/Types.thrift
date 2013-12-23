
namespace * com.github.bigtoast.apiAnalysis.thrift

/// asdf hjkfdsfdsfdhjklhjkh

struct Artist {
  10: required i64 id;
  20: required string name; 
}

struct Event {
  10: required i64 id;
  20: optional string name;
  30: required i64 time;
  40: optional set<Artist> artists; 
}

struct Ticket {
  10: required string id;
  20: required Event event;
}

service TEventService {
  set<Event> listEvents();
  set<Ticket> getTicket( 1: i64 eventId, 2: i32 count );
}