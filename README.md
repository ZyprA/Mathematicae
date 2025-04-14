
# Mathematicae

📐 A modular, object-oriented numerical computing library written in Java.  
Inspired by MATLAB, NumPy, and scientific computing needs.

---

## 🔧 Features

- 🧮 Linear algebra (matrices and vectors)
- 📊 Statistics (mean, median, standard deviation, etc.)
- ∫ Numerical integration
- 🧱 Object-oriented architecture (abstract classes, interfaces, inheritance)
- ✅ JUnit5-based testing

---

## 📦 Installation

You can include Mathematicae in your project by downloading the `.jar` file:

```groovy
// build.gradle (if local .jar)
implementation files('libs/Mathematicae-0.1.0.jar')
```

Or, use JitPack (after pushing to GitHub):

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.yourusername:Mathematicae:0.1.0'
}
```

---

## 🚀 Usage

### Example: Matrix Multiplication

```java
import com.asahi.mathematicae.matrix.DenseMatrix;

DenseMatrix A = new DenseMatrix(new double[][]{
    {1, 2},
    {3, 4}
});

DenseMatrix B = new DenseMatrix(new double[][]{
    {5, 6},
    {7, 8}
});

DenseMatrix C = A.multiply(B);
System.out.println(C);
```

### Example: Mean Calculation

```java
import com.asahi.mathematicae.stats.Statistics;

double[] data = {1.0, 2.0, 3.0, 4.0};
double mean = Statistics.mean(data);
System.out.println("Mean: " + mean);
```

---

## 🧪 Testing

```bash
./gradlew test
```

Tests are written using **JUnit 5**, located under `src/test/java`.

---

## 🏗️ Architecture

- `matrix`: matrix and vector operations
- `stats`: statistical functions
- `calculus`: numerical methods like integration
- Interfaces and abstract classes used for extensibility and clarity

---

## 🧑‍💻 Development

Pull requests welcome!  
Future plans include:

- Eigenvalue computation
- Optimization algorithms
- Visualization support

---

## 📄 License

MIT License © 2025 Zypr


---
