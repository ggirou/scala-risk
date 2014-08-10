import 'dart:convert';
import 'dart:html';

Element logs = querySelector("#logs");
InputElement sendButton = querySelector("#sendButton");
TextAreaElement eventInput = querySelector("#eventInput");

const url = "ws://127.0.0.1:9000/ws";
final ws = new WebSocket(url);
int playerId;

main() {
  sendButton.onClick.listen((_) => print(eventInput.value));
  sendButton.onClick.listen((_) => ws.send(eventInput.value));

  var eventStream = ws.onMessage.map((e) => e.data).map(JSON.decode).map(
      printEvent).listen(print);
}

printEvent(event) {
  logs.children.add(new LIElement()..text = "$event");
  return event;
}
