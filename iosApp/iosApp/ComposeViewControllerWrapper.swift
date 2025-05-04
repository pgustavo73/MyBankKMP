//
//  ComposeViewControllerWrapper.swift
//  iosApp
//
//  Created by Paulo Gustavo on 02/05/25.
//  Copyright © 2025 orgName. All rights reserved.
//
import SwiftUI
import ComposeApp

struct ComposeViewControllerWrapper: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        let composeVC = MainViewControllerKt.MainViewController()
        return HostingStatusBarController(rootViewController: composeVC)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

