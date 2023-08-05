//
//  Request.swift
//  run2challenger
//
//  Created by Dmitry Novikov on 05/08/2023.
//

import Foundation

import Foundation
import Combine

class Request: ObservableObject {
	@Published var response: String?
	@Published var loadingError: Bool

	private let serverAddress: String = "51.250.19.189"
	private let serverPort: UInt16 = 8080
	private var cancellabel: AnyCancellable?
	private var responseData: String?

	init() {
		loadingError = false
	}

	deinit {
		cancellabel?.cancel()
	}

	func postRequest(rest: String) {
		let url = URL(string: "http://\(self.serverAddress):\(self.serverPort)/\(rest)")!
		cancellabel = URLSession.shared.dataTaskPublisher(for: url)
			.map { String(data: $0.data, encoding: .utf8) }
			.replaceError(with: nil)
			.receive(on: DispatchQueue.main)
			.sink(receiveCompletion: { (suscriberCompletion) in
				switch suscriberCompletion {
					case .finished:
						if self.responseData == nil {
							self.loadingError = true
							self.response = "Uhhh, shit happens"
						} else {
							self.getRespondText()
							if self.response == nil {
								self.loadingError = true
								self.response = "Uhhh, shit happens"
							}
						}
					case .failure(let error):
						self.loadingError = true
						self.response = "Uhhh, shit happens"
						print("Ligand loading error: \(error.localizedDescription)")
				}
			}, receiveValue: { [weak self] (rawData) in
				self?.responseData = rawData
			})
	}

	private func getRespondText(){
		let lines = responseData!.components(separatedBy: .newlines)

		response = lines[0]
	}
}
