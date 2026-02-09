# Information Retrieval: Query Expansion with Synonymous Terms

## Project Overview
This project focuses on improving Information Retrieval (IR) system results by implementing **Query Expansion** techniques. The main objective is to address the vocabulary mismatch problem where users and documents use different terms to describe the same concept (e.g., "hiking" vs. "trekking") by automatically adding synonyms to the initial search queries.


## Methodology & Implementation

### 1. Baseline Retrieval
* **Indexing:** Implementation of text analysis algorithms (tokenization, stemming, stop-word removal) to create an inverted index.
* **Models:** Application of classic retrieval models such as **Vector Space Model (TF-IDF)** or **BM25** to produce initial results.

### 2. Query Expansion Techniques
The system expands the original user queries using two primary methods for finding synonyms:
* **WordNet:** Utilizing the lexical database to identify synonyms (synsets) for the terms present in the query.
* **Word Embeddings (Word2Vec):** Using state-of-the-art vector representations (Mikolov et al.) to find semantically related terms based on cosine similarity in the vector space.

### 3. Evaluation Process
The effectiveness of the expansion is measured by comparing the performance of the simple query against the expanded query using:
* **Precision:** The accuracy of the retrieved documents.
* **Recall:** The ability of the system to find all relevant documents in the collection.
* **F-measure:** The harmonic mean of Precision and Recall.
* **MAP (Mean Average Precision):** To evaluate the ranking quality of the results.

---

## Technical Specifications
* **Programming Language:** Python
* **Key Libraries:** NLTK (for WordNet), Gensim (for Word2Vec), Scikit-learn, JSON.
* **Data Handling:** Processing large-scale document collections in `.jsonl` format.

## Conclusion
The project demonstrates how semantic technologies and word representations can bridge the gap between user intent and document content, significantly enhancing the effectiveness of modern retrieval systems.