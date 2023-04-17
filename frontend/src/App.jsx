//theme
import "primereact/resources/themes/lara-light-indigo/theme.css";
//core
import "primereact/resources/primereact.min.css";
//icons
import "primeicons/primeicons.css";
//css
import "primeflex/primeflex.css";
//components
import Menu from "./components/Menu";
import Category from "./components/Category";

export default function App() {
	return (
		<div className="App">
			<Menu />
			<Category />
		</div>
	);
}
