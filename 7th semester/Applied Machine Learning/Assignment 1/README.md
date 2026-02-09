# Airbnb Data Analysis & Price Prediction

This project performs a comprehensive exploratory data analysis (EDA) and predictive modeling on Airbnb listing data. The goal is to uncover insights into the rental market and develop machine learning models to estimate listing prices. The implementation is described more analytically inside the jupyter notebook.

## Project Overview

The project follows a structured data science pipeline, from cleaning and visualization to feature engineering and regression analysis.

### 1. Data Cleaning & Preprocessing
* **Handling Missing Values:** Identification and treatment of null values in critical columns like `reviews_per_month` and `last_review`.
* **Data Transformation:** Converting categorical variables into numerical formats suitable for machine learning.
* **Outlier Detection:** Filtering extreme values in prices to ensure model stability.

### 2. Exploratory Data Analysis (EDA)
* **Geospatial Distribution:** Visualizing listing density across different neighborhoods and boroughs.
* **Price Analysis:** Examining how prices fluctuate based on room types (Entire home/apt, Private room, Shared room) and location.
* **Correlation Studies:** Using heatmaps to identify relationships between variables such as number of reviews, availability, and price.



### 3. Machine Learning & Prediction
* **Feature Selection:** Identifying the most influential factors for price prediction (e.g., location, room type, minimum nights).
* **Model Implementation:** Training various regression models, including:
    * **Linear Regression:** Establishing a baseline for price estimation.
    * **Decision Trees / Random Forest:** Capturing non-linear relationships in the data.
* **Evaluation Metrics:** Assessing model performance using Mean Squared Error (MSE) and $R^2$ scores.



## Libraries Used
* **Pandas & NumPy:** For data manipulation and numerical analysis.
* **Matplotlib & Seaborn:** For static data visualizations and statistical plots.
* **Scikit-Learn:** For preprocessing and implementing machine learning algorithms.


## Key Insights
* Identifying which neighborhoods command the highest premiums.
* Analyzing the impact of host "calculated_host_listings_count" on availability and pricing.
* Determining the minimum number of nights that maximizes host revenue vs. occupancy.