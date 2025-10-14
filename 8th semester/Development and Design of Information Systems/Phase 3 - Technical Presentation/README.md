## Phase 3 – Technical Design

### System Architecture Overview

ACCESS follows a **microservices-based architecture** for scalability, modularity, and reliability.

#### Key Benefits
- Independent development and deployment of services.  
- Fault tolerance — one service can fail without crashing the system.  
- Easy scaling for high-load services.  
- Tech diversity: each service can use the most suitable tech stack.  
- Facilitates future **AI/ML integrations**.

---

### Microservices Overview

| Service | Description |
|----------|-------------|
| **User Service** | Handles authentication and profiles. |
| **Map Service** | Displays accessibility data on an interactive Mapbox map. |
| **Navigation Service** | Generates the most accessible route using the SAP algorithm. |
| **Speech Recognition Service** | Enables voice interaction for hands-free navigation. |
| **Notification Service** | Sends push notifications (Firebase Cloud Messaging). |
| **Municipality Service** | Allows city authorities to manage public infrastructure data. |
| **Statistics Service** | Generates reports, analytics, and PDF exports. |
| **Customizable UI Service** | Offers adaptive UI themes for accessibility. |
| **Update Service** | Processes and validates accessibility reports. |

---

### Architectural Layers

1. **User Interface Layer**  
   - Flutter (Mobile), React (Web)  
   - Adaptive & accessible interface  

2. **API Gateway Layer**  
   - Entry point for all clients  
   - Manages security, logging, load balancing  

3. **Domain Layer**  
   - Encapsulates core business logic  

4. **Microservices Layer**  
   - Individual services handling data flow and logic  

5. **Database Layer**  
   - Firebase / Supabase (real-time & scalable)  
   - Power BI for analytics and visualization  

---

### Core Technologies

| Component | Technology |
|------------|-------------|
| **Frontend** | Flutter (mobile), React (web) |
| **Backend** | Dart microservices (Docker Swarm) |
| **Database** | Firebase Realtime DB / Supabase |
| **Maps & Geo** | Mapbox API |
| **Notifications** | Firebase Cloud Messaging |
| **Analytics** | Power BI API |
| **Auth** | Firebase Auth / Supabase Auth |
| **State Management** | BLoC architecture |
| **Animations** | Lottie |
| **PDF Reports** | Power BI + PDF Generation |
| **Email Service** | SMTP-based notifications |

---

### Key Algorithms

#### Accessibility Update Algorithm (Exponential Smoothing)
Each road segment has a **dynamic accessibility score (P)** updated by user reports.

The accessibility score update is defined as:


$$f(P, R, W, \alpha) = P' = P + \alpha \cdot W \cdot (R - P)$$

which can also be expressed as:

$$P' = (1 - \alpha \cdot W)\cdot P + \alpha \cdot W \cdot R$$

**Where:**
- \( P' \): Updated accessibility score  
- \( P \): Current accessibility score  
- \( R \): Reported accessibility score (0 = inaccessible, 1 = accessible)  
- \( W \): User reliability weight  
- \( \alpha \): Influence coefficient controlling how strongly new data affects the current score
**Goal:** Ensure that more reliable reports (e.g., from users with disabilities) influence accessibility color updates more significantly.

---

#### SAP Algorithm (Shortest Accessible Path)
Finds the **shortest and most accessible route** between two points.

**Input:**
- User location (`lat`, `lng`)
- Destination (`lat`, `lng`)
- Accessibility scores from Firebase
- Mapbox route data

**Process:**
1. Retrieve all candidate paths.  
2. Normalize scores to remove bias (length, turns).  
3. Combine accessibility & distance scores.  
4. Output the **optimal route**.  

**Output:**
- Route displayed on Mapbox map  
- Step-by-step guidance via voice and text  

---

### System Monitoring & Performance Goals

| Metric | Target | Implementation |
|---------|---------|----------------|
| GPS Location Update | <150ms | Geolocation Package |
| Report Submission | <250ms | Async calls + queue buffer |
| Map Refresh | <1s | Firebase RTDB + caching |
| Scalability | Dynamic | Auto-scaling via Docker & Firebase Hosting |
| Real-Time Sync | Instant | FCM + WebSockets |
| Offline Mode | Supported | Local storage sync |
| System Monitoring | Ongoing | Dashboard KPIs, Heatmaps |

---

### Statistics & Visualization
Municipal dashboards integrate with **Power BI** to:
- Visualize live user reports on city maps  
- Generate PDF reports dynamically  
- Track problem areas and accessibility changes over time  

---

### Task Management
The development process was managed via **Jira**, allowing:
- Clear task ownership by service/module  
- Sprint tracking with milestones  
- Integrated meeting notes and progress timeline  

---

### Summary
ACCESS Phase 3 transforms the conceptual design into a **fully architected system**, emphasizing:
- Scalable microservices  
- Real-time data handling  
- Adaptive and inclusive design  
- Reliable performance metrics  

This phase defines the **foundation for the implementation stage** of the project.
