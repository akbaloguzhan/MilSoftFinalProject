import { Menubar } from "primereact/menubar";
import React from "react";
import Sepet from "./Sepet";

export default function TemplateDemo() {
	const items = [{ label: "Akbal Store" }];
	const start = (
		<img alt="logo" src="/logo.png" height="60" className="mr-2"></img>
	);
	const end = <Sepet />;

	return (
		<div className="card">
			<Menubar model={items} start={start} end={end} />
		</div>
	);
}
