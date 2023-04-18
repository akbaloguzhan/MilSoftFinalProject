import { TabView, TabPanel } from "primereact/tabview";
import Urunler from "./Urunler";
import { Avatar } from "primereact/avatar";

export default function Category() {
	const name1CategoryTemplate = (options) => {
		return (
			<div
				className="flex align-items-center px-3"
				style={{ cursor: "pointer" }}
				onClick={options.onClick}
			>
				<Avatar
					image="https://primefaces.org/cdn/primereact/images/avatar/amyelsner.png"
					shape="circle"
					className="mx-2"
				/>
				<h2>Category I</h2>
			</div>
		);
	};

	const name2CategoryTemplate = (options) => {
		return (
			<div
				className="flex align-items-center px-3"
				style={{ cursor: "pointer" }}
				onClick={options.onClick}
			>
				<Avatar
					image="https://primefaces.org/cdn/primereact/images/avatar/amyelsner.png"
					shape="circle"
					className="mx-2"
				/>
				<h2>Category II</h2>
			</div>
		);
	};

	const name3CategoryTemplate = (options) => {
		return (
			<div
				className="flex align-items-center px-3"
				style={{ cursor: "pointer" }}
				onClick={options.onClick}
			>
				<Avatar
					image="https://primefaces.org/cdn/primereact/images/avatar/amyelsner.png"
					shape="circle"
					className="mx-2"
				/>
				<h2>Category III</h2>
			</div>
		);
	};

	const name4CategoryTemplate = (options) => {
		return (
			<div
				className="flex align-items-center px-3"
				style={{ cursor: "pointer" }}
				onClick={options.onClick}
			>
				<Avatar
					image="https://primefaces.org/cdn/primereact/images/avatar/amyelsner.png"
					shape="circle"
					className="mx-2"
				/>
				<h2>Category IV</h2>
			</div>
		);
	};

	return (
		<TabView>
			<TabPanel headerTemplate={name1CategoryTemplate}>
				<Urunler />
			</TabPanel>
			<TabPanel headerTemplate={name2CategoryTemplate}>
				<Urunler />
			</TabPanel>
			<TabPanel headerTemplate={name3CategoryTemplate}>
				<Urunler />
			</TabPanel>
			<TabPanel headerTemplate={name4CategoryTemplate}>
				<Urunler />
			</TabPanel>
		</TabView>
	);
}
