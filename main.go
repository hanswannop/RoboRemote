package main

import (
	"flag"
	"log"
	"net/http"
	"text/template"
)

var addr = flag.String("addr", ":8080", "http service address")
var roboTempl = template.Must(template.ParseFiles("robo.html"))
var remoteTempl = template.Must(template.ParseFiles("remote.html"))

func serveRobo(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "text/html; charset=utf-8")
	roboTempl.Execute(w, r.Host)
}

func serveRemote(w http.ResponseWriter, r *http.Request) {
        w.Header().Set("Content-Type", "text/html; charset=utf-8")
        remoteTempl.Execute(w, r.Host)
}

func main() {
	flag.Parse()
	go h.run()
	http.HandleFunc("/robo", serveRobo)
	http.HandleFunc("/remote", serveRemote)
	http.HandleFunc("/ws", serveWs)
	err := http.ListenAndServe(*addr, nil)
	if err != nil {
		log.Fatal("ListenAndServe: ", err)
	}
}
