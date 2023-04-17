import { Button } from "primereact/button";
import { DataView } from "primereact/dataview";
import { Dropdown } from "primereact/dropdown";
import { Tag } from "primereact/tag";
import React, { useEffect, useState } from "react";
import { ProductService } from "../service/ProductService";

export default function SortingDemo() {
	const [products, setProducts] = useState([]);
	//! data burada set ediliyor backend bağlantısı sonrası endpoint datası ile set edilecek
	useEffect(() => {
		ProductService.getProductsSmall().then((data) =>
			setProducts(data.slice(0, 5))
		);
	}, []);

	// TODO Veri bağlanırken data set etme işlemi yapılacak alan
// 	useEffect(() => {
// 		fetch("localhost:8080/product")
// 			.then((response) => response.json())
// 			.then((data) => setProducts(data));
// 	}, []);
  // TODO bu işlem yapıldıktan sonra aşağıda bulunan itemTemplate alanında gerekli düzenlemeler yapılacak

	const [sortKey, setSortKey] = useState("");
	const [sortOrder, setSortOrder] = useState(0);
	const [sortField, setSortField] = useState("");
	const sortOptions = [
		{ label: "Price High to Low", value: "!price" },
		{ label: "Price Low to High", value: "price" },
	];

	const getSeverity = (product) => {
		switch (product.inventoryStatus) {
			case "INSTOCK":
				return "success";

			case "LOWSTOCK":
				return "warning";

			case "OUTOFSTOCK":
				return "danger";

			default:
				return null;
		}
	};

	const onSortChange = (event) => {
		const value = event.value;

		if (value.indexOf("!") === 0) {
			setSortOrder(-1);
			setSortField(value.substring(1, value.length));
			setSortKey(value);
		} else {
			setSortOrder(1);
			setSortField(value);
			setSortKey(value);
		}
	};

	const header = () => {
		return (
			<Dropdown
				options={sortOptions}
				value={sortKey}
				optionLabel="label"
				placeholder="Sort By Price"
				onChange={onSortChange}
				className="w-full sm:w-14rem"
			/>
		);
	};

	const itemTemplate = (product) => {
		return (
			<div className="col-12">
				<div className="flex flex-column xl:flex-row xl:align-items-start p-4 gap-4">
					<img
						className="w-9 sm:w-16rem xl:w-10rem shadow-2 block xl:block mx-auto border-round"
						src={`https://primefaces.org/cdn/primereact/images/product/${product.image}`}
						alt={product.name}
					/>
					<div className="flex flex-column sm:flex-row justify-content-between align-items-center xl:align-items-start flex-1 gap-4">
						<div className="flex flex-column align-items-center sm:align-items-start gap-3">
							<div className="text-2xl font-bold text-900">{product.name}</div>
							<div className="flex align-items-center gap-3">
								<span className="flex align-items-center gap-2">
									<i className="pi pi-tag"></i>
									<span className="font-semibold">{product.category}</span>
								</span>
								<Tag
									value={product.inventoryStatus}
									severity={getSeverity(product)}
								></Tag>
							</div>
						</div>
						<div className="flex sm:flex-column align-items-center sm:align-items-end gap-3 sm:gap-2">
							<span className="text-2xl font-semibold">₺{product.price}</span>
							<Button
								icon="pi pi-shopping-cart"
								className="p-button-rounded"
								disabled={product.inventoryStatus === "OUTOFSTOCK"}
							></Button>
						</div>
					</div>
				</div>
			</div>
		);
	};

	return (
		<div className="card">
			<DataView
				value={products}
				itemTemplate={itemTemplate}
				header={header()}
				sortField={sortField}
				sortOrder={sortOrder}
			/>
		</div>
	);
}
