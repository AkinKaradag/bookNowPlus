# BookNow Plus

BookNow Plus ist die weiterentwickelte Version des Projekts [BookNow](https://github.com/dein-link).  
Der Fokus liegt auf einer sauberen, modularen Codebasis nach dem Prinzip der **Clean Architecture** sowie auf der Erweiterung und Verbesserung zentraler Funktionen.  
Das Projekt wurde eigenständig umgesetzt, um meine Kenntnisse in moderner Softwareentwicklung, Architektur und Full-Stack-Integration zu vertiefen.

## 🚀 Ziel des Projekts

Ziel war es, die ursprüngliche BookNow-Applikation technisch und architektonisch weiterzuentwickeln.  
Während BookNow die Basisfunktionen implementiert, konzentriert sich BookNow Plus auf:
- bessere Code-Struktur
- klare Trennung von Schichten
- erweiterte Funktionalitäten
- Clean Architecture im Backend

## 🧰 Tech Stack

- **Backend:** Java, Spring Boot  
- **Frontend:** React  
- **Architektur:** Clean Architecture, Schichtenmodell (Domain / Application / Infrastructure / Adapter)  
- **Datenbank:** PostgreSQL (lokal & Cloud)  
- **API:** REST  
- **Authentifizierung:** JWT (JSON Web Token)  
- **Build & Dependency:** Maven  
- **Versionierung:** Git, GitHub

## ✨ Hauptfunktionen

- Benutzerregistrierung und Login mit JWT  
- Verwaltung von Dienstleistungen durch Firmenkunden  
- Terminbuchung und Anzeige für Endkund:innen  
- Trennung von Benutzerrollen (PrivateUser / CompanyUser)  
- Verbesserte Datenvalidierung und Fehlerbehandlung  
- Einsatz von DTOs zur sauberen Kommunikation zwischen Schichten

## 🧭 Architekturüberblick

Das Backend basiert auf dem **Clean Architecture Ansatz**, wodurch:
- die Business-Logik unabhängig von Frameworks bleibt,  
- einzelne Schichten leichter test- und erweiterbar sind,  
- die Trennung zwischen Domäne, Applikation und Infrastruktur klar erkennbar ist.

**Struktur (vereinfacht):**
/domain
├── models
└── services
/application
├── usecases
/infrastructure
├── persistence
├── security
/adapters
├── web (Controller)
├── dto


Das Frontend kommuniziert über REST mit dem Backend und wurde ebenfalls modularer aufgebaut, um spätere Erweiterungen zu erleichtern.

## 🧪 Lern- und Entwicklungsfokus

- Anwendung und Verständnis von Clean Architecture  
- Saubere Trennung von Verantwortlichkeiten im Backend  
- Erweiterung und Optimierung bestehender Features  
- Frontend-Integration mit verbesserten API-Schnittstellen  
- Sicheres Authentifizierungs- und Berechtigungskonzept

## ☁️ Deployment

BookNow Plus kann lokal oder über Cloud-Umgebungen wie Google Cloud Run betrieben werden.  
Für Testzwecke kann eine PostgreSQL- oder SQLite-Datenbank verwendet werden.

## 📈 Unterschiede zu BookNow

| BookNow                       | BookNow Plus                                              |
|-------------------------------|------------------------------------------------------------|
| Schichtenarchitektur (klassisch) | Clean Architecture                                     |
| Basis-Features                 | Erweiterte Funktionalität (z. B. Rollenmodell)              |
| Einstieg in Full-Stack         | Fokus auf Struktur, Testbarkeit und Erweiterbarkeit        |
| Weniger modulare Struktur     | Klare Trennung zwischen Domäne, Applikation, Infrastruktur |

## 🧭 Nächste Schritte

- Implementierung von Unit- und Integrationstests  
- Erweiterung des Rollen- und Rechtekonzepts  
- UI-Verbesserungen für das Frontend  
- Erweiterung der CI/CD-Pipeline für Cloud-Deployments

## 📜 Lizenz / Hinweis

Dieses Projekt ist ein eigenständig entwickeltes Lern- und Showcase-Projekt zur Demonstration moderner Softwarearchitektur und Full-Stack-Entwicklung.
