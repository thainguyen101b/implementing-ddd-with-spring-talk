# Implementing Domain Driven Design with Spring

This repository contains code for the talk I gave at [Spring IO 2024](https://2024.springio.net/sessions/implementing-domain-driven-design-with-spring/): "Implementing Domain Driven Design with Spring"

- [YouTube](https://www.youtube.com/watch?v=VGhg6Tfxb60)
- [Slides](https://speakerdeck.com/maciejwalkowiak/implementing-domain-driven-desing-with-spring)

## REST API

|    Endpoint	     | Method | Status | Description    		   	                                      |
|:----------------:|:------:|:------:|:-----------------------------------------------------------|
|     `/books`     | `POST` |  201   | Add a new book to the catalog using Open Library.          |
| `/books/{isbn}`  | `GET`  |  200   | Retrieve a book by its ISBN.                               |
|    `/copies`     | `POST` |  201   | Register a new book copy with a given book ID and barcode. |
| `/copies/{code}` | `GET`  |  200   | Retrieve a book copy by its barcode.                       |
|  `/loans/rent`   | `POST` |  201   | Rent a book copy using its copy ID.                        |
| `/loans/return`  | `POST` |  204   | Return a rented book copy using its loan ID.               |

