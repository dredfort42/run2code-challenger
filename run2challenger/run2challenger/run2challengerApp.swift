//
//  run2challengerApp.swift
//  run2challenger
//
//  Created by Dmitry Novikov on 05/08/2023.
//

import SwiftUI

@main
struct run2challengerApp: App {
    let persistenceController = PersistenceController.shared

    var body: some Scene {
        WindowGroup {
			ContentView()
                .environment(\.managedObjectContext, persistenceController.container.viewContext)
        }
    }
}
